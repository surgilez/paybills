package com.ec.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-06T10:38:29")
@StaticMetamodel(VentaRuta.class)
public class VentaRuta_ { 

    public static volatile SingularAttribute<VentaRuta, String> venta;
    public static volatile SingularAttribute<VentaRuta, String> codigo;
    public static volatile SingularAttribute<VentaRuta, String> cedula;
    public static volatile SingularAttribute<VentaRuta, String> semana;
    public static volatile SingularAttribute<VentaRuta, String> transporte;
    public static volatile SingularAttribute<VentaRuta, String> direccion;
    public static volatile SingularAttribute<VentaRuta, String> nombre;
    public static volatile SingularAttribute<VentaRuta, BigDecimal> idVentaRuta;
    public static volatile SingularAttribute<VentaRuta, Date> fecha;
    public static volatile SingularAttribute<VentaRuta, String> facturado;
    public static volatile SingularAttribute<VentaRuta, String> correo;
    public static volatile SingularAttribute<VentaRuta, String> celular;
    public static volatile SingularAttribute<VentaRuta, String> cantidad;

}