package play.data;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import static play.libs.F.*;
import play.data.validation.*;

/**
 * A dynamic form. This form is backed by a simple <code>HashMap&lt;String,String></code>
 */
public class DynamicForm extends Form<DynamicForm.Dynamic> {

    private final Map<String, String> rawData;
    
    /**
     * Creates a new empty dynamic form.
     */
    public DynamicForm() {
        super(DynamicForm.Dynamic.class);
        rawData = new HashMap<String, String>();
    }
    
    /**
     * Creates a new dynamic form.
     *
     * @param data the current form data (used to display the form)
     * @param errors the collection of errors associated with this form
     * @param value optional concrete value if the form submission was successful
     */
    public DynamicForm(Map<String,String> data, Map<String,List<ValidationError>> errors, Option<Dynamic> value) {
        super(null, DynamicForm.Dynamic.class, data, errors, value);
        rawData = new HashMap<String, String>();
        for (Map.Entry<String, String> e : data.entrySet()) {
            rawData.put(asNormalKey(e.getKey()), e.getValue());
        }

    }
    
    @Override
    public DynamicForm bindFromRequest(HttpServletRequest request, String... allowedFields) {
    	Map<java.lang.String,java.lang.String[]> requestData = (Map<java.lang.String,java.lang.String[]>)request.getParameterMap();
    	
    	Map<String, String> map = requestData(requestData);
        Map<String,String> newData = new HashMap<String,String>();
        for(Map.Entry<String, String> e: map.entrySet()) {
            newData.put(asDynamicKey(e.getKey()), e.getValue());
        }
        map = newData;

    	Form<Dynamic> form =  super.bindFromRequest(request, allowedFields);
        return new DynamicForm(form.data(), form.errors(), form.value());

    }

    
    
    /**
     * Gets the concrete value if the submission was a success.
     */
    public String get(String key) {
        try {
            return (String)get().getData().get(asNormalKey(key));
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public Map<String, String> data() {
        return rawData;
    }

    /**
     * Fille with existing data.
     */
    public DynamicForm fill(Map value) {
        Form<Dynamic> form = super.fill(new Dynamic(value));
        return new DynamicForm(form.data(), form.errors(), form.value());
    }

   

    /**
     * Binds data to this form - that is, handles form submission.
     *
     * @param data data to submit
     * @return a copy of this form filled with the new data
     */
    @Override
    public DynamicForm bind(Map<String,String> data, String... allowedFields) {
        {
            Map<String,String> newData = new HashMap<String,String>();
            for(Map.Entry<String, String> e: data.entrySet()) {
                newData.put(asDynamicKey(e.getKey()), e.getValue());
            }
            data = newData;
        }
        
        Form<Dynamic> form = super.bind(data, allowedFields);
        return new DynamicForm(form.data(), form.errors(), form.value());
    }
    
    /**
     * Retrieves a field.
     *
     * @param key field name
     * @return the field - even if the field does not exist you get a field
     */
    public Field field(String key) {
        Field field = super.field(asDynamicKey(key));
        return new Field(this, key, field.constraints(), field.format(), field.errors(),
            field.value() == null ? get(key) : field.value()
        );
    }

    /**
     * Retrieve an error by key.
     */
    public ValidationError error(String key) {
        return super.error(asDynamicKey(key));
    }

    /**
     * Adds an error to this form.
     *
     * @param key the error key
     * @param error the error message
     * @param args the errot arguments
     */
    public void reject(String key, String error, List<Object> args) {
        super.reject(asDynamicKey(key), error, args);
    }

    /**
     * Adds an error to this form.
     *
     * @param key the error key
     * @param error the error message
     */    
    public void reject(String key, String error) {
        super.reject(asDynamicKey(key), error);
    }

    // -- tools

    static String asDynamicKey(String key) {
        if(key.isEmpty() || key.matches("^data\\[.+\\]$")) {
           return key;
        } else {
            return "data[" + key + "]";
        }
    }

    static String asNormalKey(String key) {
        if(key.matches("^data\\[.+\\]$")) {
           return key.substring(5, key.length() - 1);
        } else {
            return key;
        }
    }

    // -- /
    
    /**
     * Simple data structure used by <code>DynamicForm</code>.
     */
    @SuppressWarnings("rawtypes")
    public static class Dynamic {

        private Map data = new HashMap();

        public Dynamic() {
        }

        public Dynamic(Map data) {
            this.data = data;
        }

        /**
         * Retrieves the data.
         */
        public Map getData() {
            return data;
        }

        /**
         * Sets the new data.
         */
        public void setData(Map data) {
            this.data = data;
        }

        public String toString() {
            return "Form.Dynamic(" + data.toString() + ")";
        }

    }
    
}

