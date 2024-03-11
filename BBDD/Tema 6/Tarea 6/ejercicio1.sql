set serveroutput on;

create or replace procedure CambiarAgentesFamilia(p_id_FamiliaOrigen familias.identificador%type, p_id_FamiliaDestino familias.identificador%type)
as
  numAgentes number(8);
  numFamiliaOrigen number(8);
  numFamiliaDestino number(8);
  nombreFamiliaOrigen familias.nombre%type;
  nombreFamiliaDestino familias.nombre%type;
  familias_iguales exception;
begin
  
    if p_id_FamiliaOrigen = p_id_FamiliaDestino THEN
        raise familias_iguales;
    end if;
  
    select count(*) into numFamiliaOrigen
    from familias
    where identificador = p_id_FamiliaOrigen;
    
    if numFamiliaOrigen = 0 then 
        RAISE_APPLICATION_ERROR(-20001,'No existe la familia de origen');
    end if;
    
    select count(*) into numFamiliaDestino
    from familias
    where identificador = p_id_FamiliaDestino;
    
    if numFamiliaDestino = 0 then 
        RAISE_APPLICATION_ERROR(-20002,'No existe la familia de destino');
    end if;
    
    select nombre into nombreFamiliaOrigen
    from familias
    where identificador = p_id_FamiliaOrigen;
    
    select nombre into nombreFamiliaDestino
    from familias
    where identificador = p_id_FamiliaDestino;

    select count(*) into numAgentes
    from agentes
    where familia = p_id_FamiliaOrigen;

    UPDATE agentes SET familia = p_id_FamiliaDestino WHERE familia = p_id_FamiliaOrigen;

    DBMS_OUTPUT.PUT_LINE('Han sido trasladados ' || numAgentes || ' agentes de la familia ' || nombreFamiliaOrigen || ' a la familia ' || nombreFamiliaDestino);
exception
  when familias_iguales then
    DBMS_OUTPUT.PUT_LINE('Las familias no pueden ser iguales');

end;
/


begin
    CambiarAgentesFamilia(211 , 213);
end;
/
