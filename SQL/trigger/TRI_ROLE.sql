CREATE OR REPLACE TRIGGER TRI_ROLE 
 before insert OR UPDATE ON ROLE_TABLE for each row
begin
  select S_ROLE.Nextval into:new.R_ID from dual;
 end;
/
