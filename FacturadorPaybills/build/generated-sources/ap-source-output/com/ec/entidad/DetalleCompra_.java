package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:59:35")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T16:05:05")
>>>>>>> fa843b9754da8b44d406ec620103fe7702fb2250
@StaticMetamodel(DetalleCompra.class)
public class DetalleCompra_ { 

    public static volatile SingularAttribute<DetalleCompra, String> detDescripcion;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodCodigoProvee;
    public static volatile SingularAttribute<DetalleCompra, CabeceraCompra> idCabecera;
    public static volatile SingularAttribute<DetalleCompra, Integer> idIngresoProd;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodTotal;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodCantidad;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodSubtotal;
    public static volatile SingularAttribute<DetalleCompra, Producto> idProducto;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> detValorInicial;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> detFactor;

}