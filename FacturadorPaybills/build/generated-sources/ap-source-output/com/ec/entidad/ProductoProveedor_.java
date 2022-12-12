package com.ec.entidad;

import com.ec.entidad.Producto;
import com.ec.entidad.ProductoProveedorPK;
import com.ec.entidad.Proveedores;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:59:35")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T16:05:05")
>>>>>>> fa843b9754da8b44d406ec620103fe7702fb2250
@StaticMetamodel(ProductoProveedor.class)
public class ProductoProveedor_ { 

    public static volatile SingularAttribute<ProductoProveedor, Proveedores> proveedores;
    public static volatile SingularAttribute<ProductoProveedor, ProductoProveedorPK> productoProveedorPK;
    public static volatile SingularAttribute<ProductoProveedor, BigDecimal> prodProvCosto;
    public static volatile SingularAttribute<ProductoProveedor, Date> prodProvFechaReg;
    public static volatile SingularAttribute<ProductoProveedor, Producto> producto;

}