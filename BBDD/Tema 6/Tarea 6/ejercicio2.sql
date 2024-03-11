create or replace trigger controla_oficinas
before insert or update on oficinas for each row
begin

    -- 1- La longitud del código postal de una oficina no puede ser inferior a 4.
    if length(:new.codigo_postal) < 4 then 
        raise_application_error(-20001, 'La longitud del código postal de una oficina no puede ser inferior a 4.');
    end if;  
    
    -- 2- La longitud del domicilio no puede ser inferior a 1 (No puede estar vacío).
    if :new.domicilio is null or length(:new.domicilio) < 1 then 
        raise_application_error(-20002, 'La longitud del domicilio no puede ser inferior a 1 (No puede estar vacío).');
    end if;  
    
    -- 3- La longitud de la localidad no puede ser inferior a 1 (No puede estar vacío).
    if :new.localidad is null or length(:new.localidad) < 1 then 
        raise_application_error(-20003, 'La longitud de la localidad no puede ser inferior a 1 (No puede estar vacío).');
    end if;  
    
     -- 4- La longitud del nombre de una oficina no tiene que ser mayor o igual a 20.
    if length(:new.nombre) <= 20 then 
        raise_application_error(-20004, 'La longitud del nombre de una oficina no tiene que ser mayor o igual a 20.');
    end if;  


end;
/

-- SENTENCIAS PARA HACER SALTAR LOS TRIGGERS

-- 1-  La longitud del código postal de una oficina no puede ser inferior a 4.
insert into oficinas values (5, 'oficina1', 'domicilio1', 'localidad1', 77444 );

-- 2- La longitud del domicilio no puede ser inferior a 1 (No puede estar vacío).
insert into oficinas values (555, 'oficina 1', 'domicilio', 'localidad1', 03700 );

-- 3- La longitud de la localidad no puede ser inferior a 1 (No puede estar vacío).
insert into oficinas values (555, 'oficina 1', 'domicilio', 'localidad', 03700 );

-- 4- La longitud del nombre de una oficina no tiene que ser mayor o igual a 20.
insert into oficinas values (555, 'nomnbremenosde20', 'domicilio', 'localidad', 03700 );



