package com.ec.entidad;

import com.ec.entidad.Guiaremision;
import com.ec.entidad.Tipoadentificacion;
import com.ec.entidad.Tipoambiente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:59:36")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T16:05:05")
>>>>>>> fa843b9754da8b44d406ec620103fe7702fb2250
@StaticMetamodel(Transportista.class)
public class Transportista_ { 

    public static volatile SingularAttribute<Transportista, String> trpCorreo;
    public static volatile SingularAttribute<Transportista, String> trpClave;
    public static volatile CollectionAttribute<Transportista, Guiaremision> guiaremisionCollection;
    public static volatile SingularAttribute<Transportista, Integer> idTransportista;
    public static volatile SingularAttribute<Transportista, Tipoadentificacion> idTipoIdentificacion;
    public static volatile SingularAttribute<Transportista, String> trpRazonSocial;
    public static volatile SingularAttribute<Transportista, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<Transportista, String> trpMovil;
    public static volatile SingularAttribute<Transportista, String> trpDireccion;
    public static volatile SingularAttribute<Transportista, String> trpTelefono;
    public static volatile SingularAttribute<Transportista, String> trpCedula;
    public static volatile SingularAttribute<Transportista, String> trpCiudad;

}