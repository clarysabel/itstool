﻿create schema orion;

CREATE TABLE orion.roles (
  role_id SERIAL  NOT NULL ,
  name VARCHAR(20)   NOT NULL ,
  deleted BOOL      ,
PRIMARY KEY(role_id));



CREATE TABLE orion.users (
  user_id SERIAL  NOT NULL ,
  username VARCHAR(500)    ,
  password VARCHAR(100) ,
  first_name VARCHAR(100)   NOT NULL ,
  last_name VARCHAR(100)   NOT NULL ,
  email VARCHAR(100)   NOT NULL ,
  creation_date TIMESTAMP   NOT NULL ,
  last_modified TIMESTAMP   NOT NULL ,
  status  CHARACTER(1)   NOT NULL ,
  deleted BOOL  DEFAULT FALSE NOT NULL   ,
PRIMARY KEY(user_id));



CREATE TABLE orion.operations (
  operation_id SERIAL  NOT NULL ,
  name VARCHAR(50)   NOT NULL ,
  type  VARCHAR(20)   NOT NULL ,
  sql_code TEXT   NOT NULL ,
  detail VARCHAR(300)    ,
  deleted BOOL  DEFAULT FALSE    ,
PRIMARY KEY(operation_id));



CREATE TABLE orion.categories (
  category_id SERIAL  NOT NULL ,
  name VARCHAR(100)    ,
  description VARCHAR(300)    ,
  deleted BOOL  DEFAULT FALSE    ,
PRIMARY KEY(category_id));



CREATE TABLE orion.outputs (
  output_id SERIAL  NOT NULL ,
  operation_id INTEGER   NOT NULL ,
  name VARCHAR(20)    ,
  type  VARCHAR(50)    ,
  display_order  SMALLINT    ,
  display_name VARCHAR(40)    ,
  deleted BOOL  DEFAULT FALSE    ,
PRIMARY KEY(output_id),
FOREIGN KEY (operation_id) REFERENCES orion.operations (operation_id));



CREATE TABLE orion.inputs (
  input_id SERIAL  NOT NULL ,
  operation_id INTEGER   NOT NULL ,
  name VARCHAR(20)   NOT NULL ,
  type  VARCHAR(20)   NOT NULL ,
  display_name VARCHAR(40)    ,
  deleted BOOL  DEFAULT FALSE    ,
PRIMARY KEY(input_id),
FOREIGN KEY (operation_id) REFERENCES orion.operations (operation_id));



CREATE TABLE orion.users_roles (
  user_role_id SERIAL  NOT NULL ,
  role_id INTEGER   NOT NULL ,
  user_id INTEGER   NOT NULL   ,
PRIMARY KEY(user_role_id),
FOREIGN KEY (role_id) REFERENCES orion.roles (role_id),
FOREIGN KEY (user_id) REFERENCES orion.users (user_id));



CREATE TABLE orion.users_categories (
  user_category_id INTEGER   NOT NULL ,
  category_id INTEGER   NOT NULL ,
  user_id INTEGER   NOT NULL   ,
PRIMARY KEY(user_category_id),
FOREIGN KEY (category_id) REFERENCES orion.categories (category_id),
FOREIGN KEY (user_id) REFERENCES orion.users (user_id));



CREATE TABLE orion.operations_categories (
  operation_role_id SERIAL  NOT NULL ,
  category_id INTEGER   NOT NULL ,
  operation_id INTEGER   NOT NULL   ,
PRIMARY KEY(operation_role_id),
FOREIGN KEY (category_id) REFERENCES orion.categories (category_id),
FOREIGN KEY (operation_id) REFERENCES orion.operations (operation_id));



CREATE TABLE orion.operations_execution_history (
  operation_execution_history_id SERIAL  NOT NULL ,
  user_id INTEGER   NOT NULL ,
  operation_id INTEGER   NOT NULL ,
  execution_time TIMESTAMP      ,
PRIMARY KEY(operation_execution_history_id),
FOREIGN KEY (user_id) REFERENCES orion.users (user_id),
FOREIGN KEY (operation_id) REFERENCES orion.operations (operation_id));



CREATE TABLE orion.operations_execution_values (
  operation_execution_value_id SERIAL  NOT NULL ,
  input_id INTEGER   NOT NULL ,
  operation_execution_history_id INTEGER   NOT NULL ,
  value VARCHAR(200)      ,
PRIMARY KEY(operation_execution_value_id),
FOREIGN KEY (input_id) REFERENCES orion.inputs (input_id),
FOREIGN KEY (operation_execution_history_id) REFERENCES orion.operations_execution_history (operation_execution_history_id));



