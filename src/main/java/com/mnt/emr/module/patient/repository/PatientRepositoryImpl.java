package com.mnt.emr.module.patient.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.view.PatientVM;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@Service
public class PatientRepositoryImpl implements PatientRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Patient savePatient(PatientVM patientVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Patient patient = mapper.map(patientVM, Patient.class);
		patient.save();
		return patient;
	}

	@Override
	public PatientVM getPatientVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Patient patient = Patient.getPatientById(id);
		PatientVM patientVM = mapper.map(patient, PatientVM.class);
		return patientVM;
	}

	@Override
	public void saveDataToMongoCollection(String collectionName, String jsonDataToSave) {
		DBCollection dbCollection = null;
		if(!mongoTemplate.collectionExists(collectionName)) {
			dbCollection = mongoTemplate.createCollection(collectionName);
		}
		else {
			dbCollection = mongoTemplate.getCollection(collectionName);
		}
		
		DBObject dbObject = (DBObject) JSON.parse(jsonDataToSave);
		String patientId = (String) dbObject.get("patientId"); 
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("patientId", patientId );
		
		boolean isUpdate = (dbCollection.findOne(whereQuery)==null) ? false : true;
		
		if(isUpdate) {
			dbObject.put("patientId", patientId);
			dbCollection.update(whereQuery, dbObject);
		} else {
			dbObject.put("patientId", patientId);
			dbCollection.save(dbObject);
		}
	}

	@Override
	public List<PatientVM> searchPatientsByFilter(String name, String role,
			String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<Patient> patients = new ArrayList<>();
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		
		if(!name.equals("")){
			expressions.add( Expr.or (Expr.or(Expr.ilike("firstName", "%" + name + "%"), 
						Expr.ilike("middleName", "%" + name + "%")), Expr.ilike("lastName", "%" + name + "%")));
		}
		
		if(expressions.size()!=0)
		{
			Expression exp = expressions.get(0);
			for(int i =1;i<expressions.size();i++)
			{
				exp = Expr.and(exp, expressions.get(i));
			}
			
			patients = Patient.find.where(exp).findList();
		}
		else {
			patients = Patient.find.all();
		}
		
		List<PatientVM> patientVMs = new ArrayList<>();
		for(Patient p : patients) {
			PatientVM vm = mapper.map(p, PatientVM.class);
			patientVMs.add(vm);
		}
		
		return patientVMs;
	}

	@Override
	public Patient updatePatient(PatientVM vm) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Patient patient = mapper.map(vm, Patient.class);
		patient.update();
		return patient;
	}

}
