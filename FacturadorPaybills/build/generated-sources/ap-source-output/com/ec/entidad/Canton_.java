package com.ec.entidad;

import com.ec.entidad.Parroquia;
import com.ec.entidad.Provincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T16:05:05")
@StaticMetamodel(Canton.class)
public class Canton_ { 

    public static volatile SingularAttribute<Canton, Provincia> idProvincia;
    public static volatile SingularAttribute<Canton, Integer> cantNumero;
    public static volatile SingularAttribute<Canton, Integer> idCanton;
    public static volatile SingularAttribute<Canton, Boolean> cantEstado;
    public static volatile CollectionAttribute<Canton, Parroquia> parroquiaCollection;
    public static volatile SingularAttribute<Canton, String> cantNombre;

}