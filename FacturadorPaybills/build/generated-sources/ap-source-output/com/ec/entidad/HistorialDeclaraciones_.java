package com.ec.entidad;

import com.ec.entidad.Tipoambiente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:59:36")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T16:05:05")
>>>>>>> fa843b9754da8b44d406ec620103fe7702fb2250
@StaticMetamodel(HistorialDeclaraciones.class)
public class HistorialDeclaraciones_ { 

    public static volatile SingularAttribute<HistorialDeclaraciones, String> hisPathDeclaracion;
    public static volatile SingularAttribute<HistorialDeclaraciones, String> hisPathPago;
    public static volatile SingularAttribute<HistorialDeclaraciones, Date> hisFecha;
    public static volatile SingularAttribute<HistorialDeclaraciones, String> hisDescripcion;
    public static volatile SingularAttribute<HistorialDeclaraciones, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<HistorialDeclaraciones, Integer> idHistorial;
    public static volatile SingularAttribute<HistorialDeclaraciones, Integer> hisMes;
    public static volatile SingularAttribute<HistorialDeclaraciones, Integer> hisAnio;

}