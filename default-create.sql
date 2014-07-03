create table address_detail (
  id                        bigint auto_increment not null,
  patient_id                bigint not null,
  address                   varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  country                   varchar(255),
  postal_code               varchar(255),
  is_default_contact        tinyint(1) default 0,
  constraint pk_address_detail primary key (id))
;

create table auth_user (
  id                        bigint auto_increment not null,
  password                  varchar(255),
  username                  varchar(255),
  facility_id               bigint,
  user_profile_id           bigint,
  enabled                   tinyint(1) default 0,
  constraint pk_auth_user primary key (id))
;

create table clinic (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  address1                  varchar(255),
  address2                  varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  postal_code               varchar(255),
  country                   varchar(255),
  phone                     varchar(255),
  ext                       varchar(255),
  contact_name              varchar(255),
  internal_location         tinyint(1) default 0,
  dial_area_code            tinyint(1) default 0,
  display_in_scheduling     tinyint(1) default 0,
  optical_location          tinyint(1) default 0,
  facility_location         tinyint(1) default 0,
  place_of_service          varchar(255),
  facility_npi              varchar(255),
  facility_entity_id        varchar(255),
  note                      varchar(255),
  directions                varchar(255),
  constraint pk_clinic primary key (id))
;

create table doctor (
  id                        bigint auto_increment not null,
  salutation                varchar(255),
  first_name                varchar(255),
  middle_name               varchar(255),
  last_name                 varchar(255),
  gender                    varchar(255),
  date_of_birth             datetime,
  address                   varchar(400),
  city                      varchar(255),
  state                     varchar(255),
  country                   varchar(255),
  postal_code               varchar(255),
  contact_number            varchar(255),
  email                     varchar(255),
  primary_speciality        varchar(255),
  secondary_speciality      varchar(255),
  professional_qualification varchar(255),
  employment_status         varchar(255),
  professional_reg_no       varchar(255),
  federal_ein               varchar(255),
  ssn                       varchar(255),
  npi                       varchar(255),
  dea                       varchar(255),
  state_license             varchar(255),
  upin                      varchar(255),
  taxanomy                  varchar(255),
  rendering_provider        varchar(255),
  doctor_color              varchar(255),
  signature                 varchar(255),
  signature_text            varchar(255),
  allowed_scheduled_event   varchar(255),
  is_external_refer         tinyint(1) default 0,
  is_admin                  tinyint(1) default 0,
  bio                       varchar(400),
  constraint pk_doctor primary key (id))
;

create table facility (
  id                        bigint auto_increment not null,
  facility_name             varchar(255),
  salutation                varchar(255),
  contact_name              varchar(255),
  address1                  varchar(255),
  address2                  varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  country                   varchar(255),
  zip_code                  varchar(255),
  relative_url              varchar(255),
  website                   varchar(255),
  email                     varchar(255),
  status                    varchar(11),
  constraint ck_facility_status check (status in ('APPROVED','DISAPPROVED')),
  constraint pk_facility primary key (id))
;

create table group_detail (
  id                        bigint auto_increment not null,
  group_name                varchar(255),
  clia_number               varchar(255),
  provider_number           varchar(255),
  effective_date            datetime,
  expiration_date           datetime,
  doctor_id                 bigint,
  constraint pk_group_detail primary key (id))
;

create table insurance_company (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  attn                      varchar(255),
  address                   varchar(255),
  address2                  varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  postal_code               varchar(255),
  phone                     varchar(255),
  cms_id                    varchar(255),
  payer_type                varchar(255),
  constraint pk_insurance_company primary key (id))
;

create table menu (
  id                        bigint auto_increment not null,
  permission_id             bigint,
  pid                       bigint,
  constraint pk_menu primary key (id))
;

create table patient (
  id                        bigint auto_increment not null,
  salutation                varchar(255),
  first_name                varchar(255),
  middle_name               varchar(255),
  last_name                 varchar(255),
  parent                    varchar(255),
  guardian_name             varchar(255),
  nick_name                 varchar(255),
  gender                    varchar(255),
  date_of_birth             datetime,
  ssn                       varchar(255),
  phone_number              varchar(255),
  mobile_number             varchar(255),
  email                     varchar(255),
  preferred_communication   varchar(255),
  emergency_contact_name    varchar(255),
  emergency_contact_number  varchar(255),
  insurance_carrier_1_no    varchar(255),
  insurance_carrier_2_no    varchar(255),
  insurance_carrier_1_name  varchar(255),
  insurance_carrier_2_name  varchar(255),
  ethnicity                 varchar(255),
  constraint pk_patient primary key (id))
;

create table permission (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  display_name              varchar(255),
  url                       varchar(255),
  constraint pk_permission primary key (id))
;

create table pharmacy (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  address                   varchar(255),
  address2                  varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  postal_code               varchar(255),
  email                     varchar(255),
  phone                     varchar(255),
  fax                       varchar(255),
  method                    varchar(255),
  constraint pk_pharmacy primary key (id))
;

create table privileges (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  is_read                   tinyint(1) default 0,
  is_write                  tinyint(1) default 0,
  is_denied                 tinyint(1) default 0,
  permision_id              bigint,
  constraint pk_privileges primary key (id))
;

create table role (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  facility_id               bigint,
  constraint pk_role primary key (id))
;

create table task (
  id                        bigint auto_increment not null,
  priority                  varchar(255),
  status                    varchar(255),
  stat_task                 tinyint(1) default 0,
  dept                      varchar(255),
  to_task                   varchar(255),
  cc_task                   varchar(255),
  start_date                datetime,
  task_list                 varchar(255),
  task_subject              varchar(255),
  due_date                  datetime,
  fu_date                   datetime,
  exp_date                  datetime,
  completion_date           datetime,
  by_task                   varchar(255),
  comments_task             varchar(255),
  constraint pk_task primary key (id))
;

create table user_profile (
  id                        bigint auto_increment not null,
  first_name                varchar(255),
  middle_name               varchar(255),
  last_name                 varchar(255),
  gender                    varchar(255),
  date_of_birth             datetime,
  email                     varchar(255),
  contact_number            varchar(255),
  address                   varchar(255),
  city                      varchar(255),
  state                     varchar(255),
  postal_code               varchar(255),
  country                   varchar(255),
  profession_qualification  varchar(255),
  is_admin_allowed          tinyint(1) default 0,
  facility_id               bigint,
  auth_user_id              bigint,
  user_type                 varchar(17),
  constraint ck_user_profile_user_type check (user_type in ('FADMIN','SADMIN','NURSE','RN','MEDICAL_ASSISTANT','ADMIN','BILLING','LAB','MEDICAL_REPORTS','FRONT_DESK')),
  constraint pk_user_profile primary key (id))
;


create table auth_user_role (
  auth_user_id                   bigint not null,
  role_id                        bigint not null,
  constraint pk_auth_user_role primary key (auth_user_id, role_id))
;

create table role_privileges (
  role_id                        bigint not null,
  privileges_id                  bigint not null,
  constraint pk_role_privileges primary key (role_id, privileges_id))
;
alter table address_detail add constraint fk_address_detail_patient_1 foreign key (patient_id) references patient (id) on delete restrict on update restrict;
create index ix_address_detail_patient_1 on address_detail (patient_id);
alter table auth_user add constraint fk_auth_user_facility_2 foreign key (facility_id) references facility (id) on delete restrict on update restrict;
create index ix_auth_user_facility_2 on auth_user (facility_id);
alter table auth_user add constraint fk_auth_user_userProfile_3 foreign key (user_profile_id) references user_profile (id) on delete restrict on update restrict;
create index ix_auth_user_userProfile_3 on auth_user (user_profile_id);
alter table group_detail add constraint fk_group_detail_doctor_4 foreign key (doctor_id) references doctor (id) on delete restrict on update restrict;
create index ix_group_detail_doctor_4 on group_detail (doctor_id);
alter table menu add constraint fk_menu_permission_5 foreign key (permission_id) references permission (id) on delete restrict on update restrict;
create index ix_menu_permission_5 on menu (permission_id);
alter table privileges add constraint fk_privileges_permision_6 foreign key (permision_id) references permission (id) on delete restrict on update restrict;
create index ix_privileges_permision_6 on privileges (permision_id);
alter table role add constraint fk_role_facility_7 foreign key (facility_id) references facility (id) on delete restrict on update restrict;
create index ix_role_facility_7 on role (facility_id);
alter table user_profile add constraint fk_user_profile_facility_8 foreign key (facility_id) references facility (id) on delete restrict on update restrict;
create index ix_user_profile_facility_8 on user_profile (facility_id);
alter table user_profile add constraint fk_user_profile_authUser_9 foreign key (auth_user_id) references auth_user (id) on delete restrict on update restrict;
create index ix_user_profile_authUser_9 on user_profile (auth_user_id);



alter table auth_user_role add constraint fk_auth_user_role_auth_user_01 foreign key (auth_user_id) references auth_user (id) on delete restrict on update restrict;

alter table auth_user_role add constraint fk_auth_user_role_role_02 foreign key (role_id) references role (id) on delete restrict on update restrict;

alter table role_privileges add constraint fk_role_privileges_role_01 foreign key (role_id) references role (id) on delete restrict on update restrict;

alter table role_privileges add constraint fk_role_privileges_privileges_02 foreign key (privileges_id) references privileges (id) on delete restrict on update restrict;
