/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Parametrizar;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioParametrizar;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioUsuario;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class AgregarUsuario {
    
    @Wire
    Window windowIdUsuario;
    ServicioUsuario servicioUsuario = new ServicioUsuario();
    private Usuario usuarioSistema = new Usuario();
    private String tipoUSuario = "2";
    private String accion = "create";
    
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    UserCredential credential = new UserCredential();
    private String amRuc = "";
    private Tipoambiente amb = new Tipoambiente();
    ServicioParametrizar servicioParametrizar = new ServicioParametrizar();
    private Boolean readOnly = true;
    
    @AfterCompose
    public void afterCompose(@ExecutionArgParam("usuario") Usuario usuarioSistema, @ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        if (usuarioSistema != null) {
            this.usuarioSistema = usuarioSistema;
            tipoUSuario = this.usuarioSistema.getUsuNivel().toString();
            accion = "update";
            
        } else {
            this.usuarioSistema = new Usuario();
            accion = "create";
            
        }
    }
    
    public AgregarUsuario() {
        
        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());
        readOnly = credential.getUsuarioSistema().getUsuNivel() == 1 ? Boolean.FALSE : Boolean.TRUE;
    }
    
    public Usuario getUsuarioSistema() {
        return usuarioSistema;
    }
    
    public void setUsuarioSistema(Usuario usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }
    
    public String getTipoUSuario() {
        return tipoUSuario;
    }
    
    public void setTipoUSuario(String tipoUSuario) {
        this.tipoUSuario = tipoUSuario;
    }
    
    @Command
    @NotifyChange("usuarioSistema")
    public void guardar() {
        if (usuarioSistema != null && !usuarioSistema.getUsuNombre().equals("")
                    && !usuarioSistema.getUsuLogin().equals("")
                    && !tipoUSuario.equals("")) {
            usuarioSistema.setUsuNivel(Integer.valueOf(tipoUSuario));
           if (usuarioSistema.getUsuWhatsapp() == null) {
                Clients.showNotification("Ingrese un numero de contacto..!!",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                return;
            }
            if (usuarioSistema.getUsuRuc().length() != 13) {
                Clients.showNotification("Ingrese un RUC valido..!!",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                return;
            }

            Usuario usuariovalida = servicioUsuario.FindUsuarioPorNombre(usuarioSistema.getUsuLogin());
            if (usuariovalida != null) {
                Clients.showNotification("El nombre de usuario ya se encuentra en uso..!!",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                return;
            }
            usuarioSistema.setUsuFechaRegistro(new Date());
            Date fecha = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(fecha);
            c.add(Calendar.DATE, 30);
            usuarioSistema.setUsuFechaPago(c.getTime());
            usuarioSistema.setUsuIlimitado(Boolean.TRUE);
            if (accion.contains("create")) {
                if (Integer.valueOf(tipoUSuario) == 1) {
                    usuarioSistema.setUsuTipoUsuario("ADMINISTRADOR");
                } else if (Integer.valueOf(tipoUSuario) == 2) {
                    usuarioSistema.setUsuTipoUsuario("VENTAS");
                }
                servicioUsuario.crear(usuarioSistema);
            } else {
                if (Integer.valueOf(tipoUSuario) == 1) {
                    usuarioSistema.setUsuTipoUsuario("ADMINISTRADOR");
                } else if (Integer.valueOf(tipoUSuario) == 2) {
                    usuarioSistema.setUsuTipoUsuario("VENTAS");
                }
                servicioUsuario.modificar(usuarioSistema);
            }
            // verifica si existe sino lo crea
            Tipoambiente tipoAmbienteRecup = servicioTipoAmbiente.findALlTipoambientePorUsuario(usuarioSistema);

            if (tipoAmbienteRecup == null) {
                // PRUEBAS
                Tipoambiente tipoambiente = new Tipoambiente();
                
                tipoambiente.setAmDirBaseArchivos("//DOCUMENTOSRI");
                tipoambiente.setAmCodigo("1");
                tipoambiente.setAmDescripcion("PRUEBAS");
                tipoambiente.setAmEstado(Boolean.TRUE);
                tipoambiente.setAmIdEmpresa(1);
                tipoambiente.setAmUsuariosri("PRUEBA");
                tipoambiente.setAmUrlsri("celcer.sri.gob.ec");
                
                tipoambiente.setAmDirReportes("REPORTES");
                tipoambiente.setAmGenerados("GENERADOS");
                tipoambiente.setAmDirXml("XML");
                tipoambiente.setAmFirmados("FIRMADOS");
                tipoambiente.setAmTrasmitidos("TRASMITIDOS");
                tipoambiente.setAmDevueltos("DEVUELTOS");
                tipoambiente.setAmFolderFirma("FIRMA");
                tipoambiente.setAmAutorizados("AUTORIZADOS");
                tipoambiente.setAmNoAutorizados("NOAUTORIZADOS");
                tipoambiente.setAmTipoEmision("1");
                tipoambiente.setAmEnviocliente("ENVIARCLIENTE");
                tipoambiente.setAmRuc(usuarioSistema.getUsuRuc());
                tipoambiente.setAmNombreComercial("");
                tipoambiente.setAmRazonSocial("");
                tipoambiente.setAmDireccionMatriz("QUITO");
                tipoambiente.setAmDireccionSucursal("QUITO");
                
                tipoambiente.setAmPort("587");
                tipoambiente.setAmProtocol("smtp");
                tipoambiente.setLlevarContabilidad("NO");
                tipoambiente.setAmMicroEmp(Boolean.FALSE);
                tipoambiente.setAmAgeRet(Boolean.FALSE);
                tipoambiente.setAmContrEsp(Boolean.FALSE);
                tipoambiente.setAmExp(Boolean.FALSE);
                tipoambiente.setIdUsuario(usuarioSistema);
                servicioTipoAmbiente.crear(tipoambiente);

                // PRODUCCION
                Tipoambiente tipoambienteProd = new Tipoambiente();
                tipoambienteProd.setAmDirBaseArchivos("//DOCUMENTOSRI");
                tipoambienteProd.setAmCodigo("2");
                tipoambienteProd.setAmDescripcion("PRODUCCION");
                tipoambienteProd.setAmEstado(Boolean.FALSE);
                tipoambienteProd.setAmIdEmpresa(1);
                tipoambienteProd.setAmUsuariosri("PRODUCCION");
                tipoambienteProd.setAmUrlsri("cel.sri.gob.ec");
                tipoambienteProd.setAmFolderFirma("FIRMA");
                tipoambienteProd.setAmDirReportes("REPORTES");
                tipoambienteProd.setAmGenerados("GENERADOS");
                tipoambienteProd.setAmDirXml("XML");
                tipoambienteProd.setAmFirmados("FIRMADOS");
                tipoambienteProd.setAmTrasmitidos("TRASMITIDOS");
                tipoambienteProd.setAmDevueltos("DEVUELTOS");
                tipoambienteProd.setAmAutorizados("AUTORIZADOS");
                tipoambienteProd.setAmNoAutorizados("NOAUTORIZADOS");
                tipoambienteProd.setAmTipoEmision("1");
                tipoambienteProd.setAmEnviocliente("ENVIARCLIENTE");
                tipoambienteProd.setAmRuc(usuarioSistema.getUsuRuc());
                tipoambienteProd.setAmNombreComercial("");
                tipoambienteProd.setAmRazonSocial("");
                tipoambienteProd.setAmDireccionMatriz("QUITO");
                tipoambienteProd.setAmDireccionSucursal("QUITO");
                
                tipoambienteProd.setAmPort("587");
                tipoambienteProd.setAmProtocol("smtp");
                tipoambienteProd.setLlevarContabilidad("NO");
                tipoambienteProd.setAmMicroEmp(Boolean.FALSE);
                tipoambienteProd.setAmAgeRet(Boolean.FALSE);
                tipoambienteProd.setAmContrEsp(Boolean.FALSE);
                tipoambienteProd.setAmExp(Boolean.FALSE);
                tipoambienteProd.setIdUsuario(usuarioSistema);
                servicioTipoAmbiente.crear(tipoambienteProd);
                
                Parametrizar parametrizar = new Parametrizar();
                parametrizar.setParContactoEmpresa(tipoambiente.getAmRazonSocial());
                parametrizar.setParEmpresa(tipoambiente.getAmNombreComercial());
                parametrizar.setParRucEmpresa(tipoambiente.getAmRuc());
                parametrizar.setParIva(BigDecimal.valueOf(12));
                parametrizar.setParUtilidad(BigDecimal.ZERO);
                parametrizar.setParUtilidadPreferencial(BigDecimal.TEN);
                parametrizar.setParUtilidadPreferencialDos(BigDecimal.ZERO);
                parametrizar.setParEstado(Boolean.FALSE);
                parametrizar.setIsprincipal(Boolean.TRUE);
                parametrizar.setParDescuentoGeneral(BigDecimal.ZERO);
                parametrizar.setParCodigoIva("2");
                parametrizar.setParIvaActual(BigDecimal.valueOf(12));
                servicioParametrizar.crear(parametrizar);
            }
            
            

//            usuarioSistema = new Usuario();
            windowIdUsuario.detach();
            
        } else {
            Messagebox.show("Verifique la informacion ingresada", "Atención", Messagebox.OK, Messagebox.ERROR);
        }
    }
    
    public Boolean getReadOnly() {
        return readOnly;
    }
    
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }
    
}
