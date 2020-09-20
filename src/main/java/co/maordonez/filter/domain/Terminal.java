package co.maordonez.filter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@DynamicUpdate
@Entity
@Table(name = "Terminal")
public class Terminal {
	
	 public interface Attributes {
		 
		 String ID = "id";
		 String SERIAL= "serial";
		 String FLAG_INICIALIZACION = "flagInicializacion";
		 String TLS = "tls";
		 String BLOCKING_MODE = "blockingMode";
		 String APLICACIONES_INSTALADAS = "aplicacionesInstaladas";
		 String MARCA_TERMINAL = "marcaTerminal";
		 String ESTADO_ACTUALIZACION = "estadoActualizacion";
	 }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ter_id")
	private Long id;

	@Column(name = "ter_serial")
	private String serial;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ter_tipo_terminal_id")
	private TipoTerminal tipoTerminal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ter_marca_terminal_id")
	private MarcaTerminal marcaTerminal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ter_modelo_terminal_id")
	private ModeloTerminal modeloTerminal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ter_interface_terminal_id")
	private InterfaceTerminal interfaceTerminal;

	@Column(name = "ter_serial_sim")
	private String serialSim;
	
	@Column(name = "ter_telefono_sim")
	private String telefonoSim;

	@Column(name = "ter_imei")
	private String imei;
	
	@Column(name = "ter_serial_cargador")
	private String serialCargador;
	
	@Column(name = "ter_serial_bateria")
	private String serialBateria;
	
	@Column(name = "ter_serial_lector_biometrico")
	private String serialLectorBiometrico;
	
	@Column(name = "ter_descripcion")
	private String descripcion;

	@Column(name = "ter_grupo_id")
	private Long grupoId;
	
	@Column(name = "ter_prioridad_grupo")
	private Integer prioridadGrupo;
	
	@Column(name = "ter_actualizar")
	private Integer actualizarGrupo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter_fecha_programada_actualizacion")
	private  Date fechaProgramadaActualizacion;
	
	@Column(name = "ter_ip_descarga")
	private String ipDescarga;
	
	@Column(name = "ter_puerto_descarga")
	private String puertoDescarga;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ter_estado_actualizacion_id")
	private EstadoActualizacion estadoActualizacion;
	
	@Column(name = "ter_mensaje_actualizacion")
	private String mensajeActualizacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ter_tipo_estado_id")
	private TipoEstado tipoEstado;
	
	@Column(name = "ter_validar_imei")
	private Integer validarImei;
	
	@Column(name = "ter_validar_sim")
	private Integer validarSim;
	
	@Column(name = "ter_latitud_gps")
	private String latitudGps;
	
	@Column(name = "ter_longitud_gps")
	private String longitudGps;
	
	@Column(name = "ter_apn")
	private String apn;
	
	@Column(name = "ter_nivel_gprs")
	private String nivelGps;
	
	@Column(name = "ter_nivel_bateria")
	private String nivelBateria;
	
	@Column(name = "ter_aplicaciones_instaladas")
	private String aplicacionesInstaladas;
	
	@Column(name = "ter_aplicaciones_permitidas")
	private String aplicacionesPermitidas;
	
	@Column(name = "ter_ram")
	private String ram;
	
	@Column(name = "ter_ip_dispositivo")
	private String ipDispositivo;
	
	@Column(name = "ter_clave_bloqueo")
	private String claveBloqueo;
	
	@Column(name = "ter_mensaje_desplegar")
	private String mensajeDesplegar;
	
	@Column(name = "ter_bloqueo")
	private Integer bloqueo; 
	
	@Column(name = "ter_tiempo")
	private String tiempo;
	
	@Column(name = "ter_id_heracles")
	private String idHeracles;
	
	@Column(name = "ter_nombre_heracles")
	private String nombreHeracles;
	
	@Column(name = "ter_ciudad_heracles")
	private String ciudadHeracles;
	
	@Column(name = "ter_region_heracles")
	private String ter_region_heracles;
	
	@Column(name = "ter_agencia_heracles")
	private String agendaHeracles;
	
	@Column(name = "ter_componente_1")
	private String componente1;	

	@Column(name = "ter_componente_1_inyectado")
	private String componente1Inyectado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter_fecha_componente1")
	private Date fechaComponente1;
	
	@Column(name = "ter_componente_2")
	private String componente2;
	
	@Column(name = "ter_componente_2_inyectado")
	private String componente2Inyectado;
	
	@Column(name = "ter_fecha_componente2")
	private Date fechaComponente2;
	
	@Column(name = "ter_componentes_inyectados")
	private Integer componentesInyectados;
	
	@Column(name = "ter_llave_cargada")
	private Integer llaveCargada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter_fecha_ultima_carga_llave")
	private Date fechaUltimaCargaLlave;
	
	@Column(name = "ter_recargar_llave")
	private Integer recargarLlave;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter_fecha_actualizacion_auto")
	private Date fechaActualizacionAuto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter_fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter_fecha_actualizacion")
	private Date fechaActualizacion;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "ter_hora")
	private Date hora;
	
	@Column(name = "ter_aplicaciones_pendientes_sp")
	private String aplicacionesPendientesSp;
	
	@Column(name = "ter_fecha_descarga_sp")
	private String fechaDescargaSp;
	
	@Column(name = "ter_ip_descarga_sp")
	private String ipDescargaSp;
	
	@Column(name = "ter_puerto_descarga_sp")
	private String puertoDescargaSp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter_fecha_consulta_sp")
	private Date fechaConsultaSp;
	
	@Column(name = "ter_aplicacion_kiosko")
	private String aplicacionKiosko;
	
	@Column(name = "ter_blocking_mode")
	private Integer blockingMode;
	
	@Column(name = "ter_update_now")
	private Integer updateNow;
	
	@Column(name = "ter_codigo_producto")
	private String codigoProducto;
	
	@Column(name = "ter_flag_inicializacion")
	private Boolean flagInicializacion;
	
	@Column(name = "ter_flag_TLS")
	private Boolean tls;

	
}