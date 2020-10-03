package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.ProductoCategoria;
import vista.VistaProducto;

public class ControladorProducto implements ActionListener {
	private VistaProducto vista;
	private ProductoCategoria producto;
	private ConsultasProducto modelo;

	public ControladorProducto(VistaProducto vista, ProductoCategoria producto, ConsultasProducto modelo) {
		this.vista = vista;
		this.producto = producto;
		this.modelo = modelo;
		/* Producto */
		vista.btnRegistrar.addActionListener(this);
		vista.btnBuscar.addActionListener(this);
		vista.btnLimpiar.addActionListener(this);
		vista.btnModificar.addActionListener(this);
		vista.btnEliminar.addActionListener(this);

		/* Categoria */
		vista.btnGuardarCategoria.addActionListener(this);
		vista.btnBuscarPorCodigoCategoria.addActionListener(this);
		vista.btnModificarCategoria.addActionListener(this);
		vista.btnEliminarPorCategoria.addActionListener(this);
		
		/* Ventas */
		vista.btnComprobarDisponibilidad.addActionListener(this);
		vista.btnVender.addActionListener(this);
		vista.btnEliminarVenta.addActionListener(this);
	}

	public void iniciar() {
		vista.setTitle("DESAYUNOS LUISITO GUADALAJARA");
		vista.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent botonAcciones) {
		/* insertar en tabla producto */
		if (botonAcciones.getSource() == vista.btnRegistrar) {
			/* verifica que todos los espacios en blanco sean llenados por usuario */
			if (String.valueOf(vista.txtPlatillo.getText()).compareTo("") == 0
					|| String.valueOf(vista.txtCodigo.getText()).compareTo("") == 0
					|| String.valueOf(vista.txtPrecio.getText()).compareTo("") == 0
					|| String.valueOf(vista.comboBoxCantidad.getSelectedItem().toString()).compareTo("") == 0
					|| String.valueOf(vista.textAreaIngredientes.getText()).compareTo("") == 0
					|| String.valueOf(vista.txtidCategoria.getText()).compareTo("") == 0) {

				JOptionPane.showMessageDialog(null, "Debes Completar Todos Los Campos", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {

				/* toma el valor que hay en este elemento */
				producto.setCodigo(vista.txtCodigo.getText());
				
				/* si encuentra un registro igual al que se quiere insertar indica al usuario que ese 
				 	codigo ya existe y no hace la insercion */
				if (modelo.buscar(producto) == true) {
					JOptionPane.showMessageDialog(null, "Este Codigo Ya Existe", "Warning",
							JOptionPane.WARNING_MESSAGE);
					limpiarCajas();
				}
				
				/* si el registro es diferente al registro en DB inserta ese nuevo registro */
				if (modelo.buscar(producto) != true) {

					producto.setIdCategoria(Integer.parseInt(vista.txtidCategoria.getText()));
						/* busca si ya existe ese id de tabla categoria, si ya existe inserta, si no existe
						 	no inserta */
					if (modelo.buscarCategoriaPorId(producto) != true) {
						JOptionPane.showMessageDialog(null,
								"id Categoria debe corresponder con un idCategoria de Tabla Categoria Para Poder Pertenecer",
								"Warning", JOptionPane.WARNING_MESSAGE);
						limpiarCajas();
					}
						/* inserta nuevo registro si el id de categoria corresponde con uno que ya estuviese
						 	guardado ahi */
					if (modelo.buscarCategoriaPorId(producto) == true) {
						/* toma todos los valores de sus campos correspondientes */
						producto.setPlatillo(vista.txtPlatillo.getText());
						producto.setCodigo(vista.txtCodigo.getText());
						producto.setPrecio(vista.txtPrecio.getText());
						producto.setCantidad(vista.comboBoxCantidad.getSelectedItem().toString());
						producto.setIngredientes(vista.textAreaIngredientes.getText());
						producto.setCodigoCategoria(Integer.parseInt(vista.txtidCategoria.getText()));
							/* se hace la insercion */
						if (modelo.insertar(producto) == true) {
							JOptionPane.showMessageDialog(null, "Registro Insertado Correctamente.");
							limpiarCajas();
							
							/* muestra el perfil del producto insertado */
							vista.lblPerfilPlatillo.setVisible(true);
							vista.btnLimpiar.setVisible(true);
							vista.textAreaPerfilPlatillo.setVisible(true);
							vista.textAreaPerfilPlatillo.setText("PLATILLO: " + producto.getPlatillo()
									+ "\n\nREGISTRO: " + producto.getCodigo() + "\n\nPRECIO: " + producto.getPrecio()
									+ "\n\nCANTIDAD: " + producto.getCantidad() + "\n\nIDCATEGORIA: "
									+ producto.getCodigoCategoria() + "\n\nINGREDIENTES: "
									+ producto.getIngredientes());
							/* si no es posible insertar el nuevo registro marca error */
						} else {
							JOptionPane.showMessageDialog(null,"Error Al Insertar Registro","ERROR",JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
						}
					}
				}
			}
		}
		
				// Buscar Platillo
				if (botonAcciones.getSource() == vista.btnBuscar) {
						/* verifica que el campo de texto halla sido llenado */
					if (String.valueOf(vista.txtCodigo.getText()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(null, "Debes Indicar El Codigo Del Platillo");
					}else{
						/* toma la informacion dada por el usuario */
						producto.setCodigo(vista.txtCodigo.getText());
							
							/* si encuentra el codigo, muestra todo el perfil de ese producto guardado */
						if (modelo.buscar(producto) == true) { 
							JOptionPane.showMessageDialog(null, "Codigo Encontrado.");
							vista.lblPerfilPlatillo.setVisible(true);
							vista.textAreaPerfilPlatillo.setVisible(true);
							vista.btnLimpiar.setVisible(true);
							vista.btnModificar.setVisible(true);
							vista.textAreaIngredientes.setVisible(true);
							vista.lblIngredientes.setVisible(true);
							vista.txtidCategoria.setVisible(true);
							vista.txtidCategoria.setEditable(false);
							vista.lblidCategoria.setVisible(true);

							vista.textAreaPerfilPlatillo.setText("IdPRODUCTO: " + String.valueOf(producto.getIdProducto())
									+ "\n\nPLATILLO: " + producto.getPlatillo() + "\n\nREGISTRO: " + producto.getCodigo()
									+ "\n\nPRECIO: " + producto.getPrecio() + "\n\nCANTIDAD: " + producto.getCantidad()
									+ "\n\nIdCATEGORIA: " + producto.getCodigoCategoria() + "\n\nINGREDIENTES: \n"
									+ producto.getIngredientes());

							vista.lblPlatillo.setVisible(true);
							vista.txtPlatillo.setVisible(true);
							vista.lblPrecio.setVisible(true);
							vista.txtPrecio.setVisible(true);
							vista.lblCantidad.setVisible(true);
							vista.comboBoxCantidad.setVisible(true);
							vista.btnBuscar.setVisible(false);

							vista.txtPlatillo.setText(producto.getPlatillo());
							vista.txtCodigo.setText(producto.getCodigo());
							vista.txtPrecio.setText(producto.getPrecio());
							vista.comboBoxCantidad.setSelectedIndex(0);
							vista.txtidProducto.setText(String.valueOf(producto.getIdProducto()));
							vista.textAreaIngredientes.setText(producto.getIngredientes());
							vista.txtidCategoria.setText(String.valueOf(producto.getCodigoCategoria()));
							/* si no se encuentra ese registro, muestra mensaje acerca de platillo no 
							  	encontrado*/
						} else {
							JOptionPane.showMessageDialog(null,"No Existe Ese Platillo",
									"Warning", JOptionPane.WARNING_MESSAGE);
							limpiarCajas();
						}
					}
				}

		
				/* Modificar en tabla producto */
				if (botonAcciones.getSource() == vista.btnModificar) {
					/* Se verifica todos los campos esten llenos */
					if (String.valueOf(vista.txtPlatillo.getText()).compareTo("") == 0
							|| String.valueOf(vista.txtCodigo.getText()).compareTo("") == 0
							|| String.valueOf(vista.txtPrecio.getText()).compareTo("") == 0
							|| String.valueOf(vista.comboBoxCantidad.getSelectedItem().toString()).compareTo("") == 0
							|| String.valueOf(vista.textAreaIngredientes.getText()).compareTo("") == 0) {
						
						JOptionPane.showMessageDialog(null, "Debes Completar Todos Los Campos", "Warning",
								JOptionPane.WARNING_MESSAGE);

					} else {
						/* si todos los campos estan llenos, hace la modificacion */
						producto.setIdProducto(Integer.parseInt(vista.txtidProducto.getText()));
						producto.setPlatillo(vista.txtPlatillo.getText());
						producto.setCodigo(vista.txtCodigo.getText());
						producto.setPrecio(vista.txtPrecio.getText());
						producto.setCantidad(vista.comboBoxCantidad.getSelectedItem().toString());
						producto.setIngredientes(vista.textAreaIngredientes.getText());

						if (modelo.modificar(producto) == true) {
							JOptionPane.showMessageDialog(null, "Registro Modificado Correctamente...");
							limpiarCajas();

							/* se presenta el producto modificado */	
							vista.textAreaPerfilPlatillo.setText("idProducto: " + String.valueOf(producto.getIdProducto())
									+ "\n\nPLATILLO: " + producto.getPlatillo() + "\n\nREGISTRO: " + producto.getCodigo()
									+ "\n\nPRECIO: " + producto.getPrecio() + "\n\nCANTIDAD: " + producto.getCantidad()
									+ "\n\nINGREDIENTES: \n" + producto.getIngredientes() + "\n\nIdCATEGORIA: \n"
									+ producto.getCodigoCategoria());
							/* mensaje en caso de no poder modificar ese producto */
						} else {
							JOptionPane.showMessageDialog(null,"No Es Posible Modificar Este Registro",
									"Warning", JOptionPane.WARNING_MESSAGE);
							limpiarCajas();
						}
					}
				}
		
				/* Elimina un registro de tabla producto */
				if (botonAcciones.getSource() == vista.btnEliminar) {
					/* se verifica que el campo sea llenado por el usuario */
					if (String.valueOf(vista.txtCodigo.getText()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(null, "Indica El Codigo A Eliminar", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
						/* se toma valor de este campo de texto para poder buscarlo primeramente */
						producto.setCodigo(vista.txtCodigo.getText());

						/* si se encuentra el registro pregunta si realmente se desea eliminar al usuario */
						if (modelo.buscar(producto) == true) {

							int response = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres Eliminar este Registro?",
									"Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							/* si el usuario acepta eliminar ese registro */
							if (response == JOptionPane.YES_OPTION) {
								/* toma el valor que esta en este campo de texto */
								vista.txtidProducto.setText(String.valueOf(producto.getIdProducto()));
								producto.setIdProducto(Integer.parseInt(vista.txtidProducto.getText()));
								/* se hace la eliminacion de ese registro en especifico */
								if (modelo.eliminar(producto) == true) {
									JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente.");
									limpiarCajas();
								}
							}
							/* si el usuario no desea eliminar ese registro, simplemente se limpian las cajas
							 	de texto */
							if (response == JOptionPane.NO_OPTION) {
								limpiarCajas();
							}

							/* en caso de que ese registro no se halla encontrado muestra mensaje */	
						} else {
							JOptionPane.showMessageDialog(null,"Registro No Encontrado",
									"Warning", JOptionPane.WARNING_MESSAGE);
							limpiarCajas();
						}
					}
				}
				
				
				/* inserta registro en tabla categoria */
				if (botonAcciones.getSource() == vista.btnGuardarCategoria) {
					/* verifica que las cajas de texto hallan sido llenadas por el usuario */
					if (String.valueOf(vista.txtCategoria.getText()).compareTo("") == 0
							|| String.valueOf(vista.textAreaDescripcionCategoria.getText()).compareTo("") == 0
							|| String.valueOf(vista.txtRegistroCodigoCategoria.getText()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(null, "Debes Completar Todos Los Campos", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
						/* se toma el valor de este elemento */
						producto.setCodigoTablaCategoria(vista.txtRegistroCodigoCategoria.getText());
						/* busca primeramente si ese registro ya habia sido insertado */
						if (modelo.buscarCategoria(producto) == true) {
							/* si ese registro ya existia, no permite ser insertado */
							JOptionPane.showMessageDialog(null, "Este Codigo Ya Existe", "Warning",
									JOptionPane.WARNING_MESSAGE);
							limpiarCajas();
						}
						/*si es un registro diferente a uno que ya este en tabla categoria */
						if (modelo.buscarCategoria(producto) != true) {
							/* toma valores de elementos */
							producto.setCategoria(vista.txtCategoria.getText());
							producto.setDescripcion(vista.textAreaDescripcionCategoria.getText());
							producto.setCodigoTablaCategoria(vista.txtRegistroCodigoCategoria.getText());
							/* se inserta el nuevo registro */
							if (modelo.insertarCategoria(producto) == true) {
								JOptionPane.showMessageDialog(null, "Registro Insertado Correctamente.");
								limpiarCajas();
								vista.lblPerfilPlatillo.setVisible(true);
								vista.textAreaPerfilPlatillo.setVisible(true);
								vista.btnLimpiar.setVisible(true);
								/* muestra el nuevo perfil que se acaba de insertar */
								vista.textAreaPerfilPlatillo.setText("CATEGORIA: " + producto.getCategoria() + "\n\nCODIGO: "
										+ producto.getCodigoTablaCategoria() + "\n\nDESCRIPCION: \n\n"
										+ producto.getDescripcion());
								/* si no fue posible insertarse, muestra un mensaje de error */
							} else {
								JOptionPane.showMessageDialog(null,"Error Al Insertar Registro","ERROR",JOptionPane.ERROR_MESSAGE);
								limpiarCajas();
							}
						}
					}
				}
				/* busca en tabla categoria por codigo */
				if (botonAcciones.getSource() == vista.btnBuscarPorCodigoCategoria) {
						/* se verifica que no quede el elemento vacio */
					if (String.valueOf(vista.txtRegistroCodigoCategoria.getText()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(null, "Indica El Codigo A Buscar", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
						/* se toma el valor de esa caja de texto */
						producto.setCodigoTablaCategoria(vista.txtRegistroCodigoCategoria.getText());
							/* si el codigo fue encontrado muestra el perfil */
						if (modelo.buscarCategoria(producto) == true) {
							JOptionPane.showMessageDialog(null, "Codigo Encontrado.");

							vista.lblCategoriaNombre.setVisible(true);
							vista.txtCategoria.setVisible(true);
							vista.lblDescripcion.setVisible(true);
							vista.textAreaDescripcionCategoria.setVisible(true);
							vista.textAreaPerfilPlatillo.setVisible(true);
							vista.btnLimpiar.setVisible(true);

							vista.btnModificarCategoria.setVisible(true);

							vista.textAreaPerfilPlatillo.setText("IdCATEGORIA: " + producto.getIdCategoria()
									+ "\n\nNOMBRE CATEGORIA: " + producto.getCategoria() + "\n\nCODIGO: " + producto.getCodigo()
									+ "\n\nDESCRIPCION: \n\n" + producto.getDescripcion());

							vista.txtCategoria.setText(producto.getCategoria());
							vista.textAreaDescripcionCategoria.setText(producto.getDescripcion());
							vista.txtRegistroCodigoCategoria.setText("");
							vista.txtidCategoriaCategoria.setText(String.valueOf(producto.getIdCategoria()));
							/* si ese registro no fue encontrado manda mensaje a usuario */
						} else {
							JOptionPane.showMessageDialog(null, "No Existe Esa Categoria", "Warning",
									JOptionPane.WARNING_MESSAGE);
							limpiarCajas();
						}
					}
				}		
					/* permite modificar valores de algun registro de tabla categoria */
				if (botonAcciones.getSource() == vista.btnModificarCategoria) {
						/* verifica que no se dejen espacios en blanco por parte del usuario */
					if (String.valueOf(vista.txtCategoria.getText()).compareTo("") == 0
							|| String.valueOf(vista.txtRegistroCodigoCategoria.getText()).compareTo("") == 0
							|| String.valueOf(vista.textAreaDescripcionCategoria.getText()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(null, "Debes Llenar Todos Los Campos", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
						/* si no hay ningun espacio en blanco, se toman todos los valores de cada elemento */
						producto.setIdCategoria(Integer.parseInt(vista.txtidCategoriaCategoria.getText()));
						producto.setCategoria(vista.txtCategoria.getText());
						producto.setCodigoTablaCategoria(vista.txtRegistroCodigoCategoria.getText());
						producto.setDescripcion(vista.textAreaDescripcionCategoria.getText());
							/*se modifica ese registro */
						if (modelo.modificarCategoria(producto) == true) {
							JOptionPane.showMessageDialog(null, "Registro Modificado Correctamente...");
							limpiarCajas();
							/* se muestra el nuevo perfil del registro que acaba de ser modificado */
							vista.textAreaPerfilPlatillo.setText("IdCATEGORIA: " + String.valueOf(producto.getIdCategoria())
									+ "\n\nCATEGORIA: " + producto.getCategoria() + "\n\nCODIGO: "
									+ producto.getCodigoTablaCategoria() + "\n\nDESCRIPCION: \n\n" + producto.getDescripcion());
							/* en caso de no ser posible modificarse ese registro muestra mensaje al usuario */
						} else {
							JOptionPane.showMessageDialog(null, "No Es Posible Modificar Este Registro", "Warning",
									JOptionPane.WARNING_MESSAGE);
							limpiarCajas();
						}
					}
				}		
					/*elimina un registro de tabla categoria */
				if (botonAcciones.getSource() == vista.btnEliminarPorCategoria) {
						/* se verifica no se dejen espacios en blanco por el usuario */
					if (String.valueOf(vista.txtCodigoBorrarPorCategoria.getText()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(null, "Indica El Id De La Categoria A Eliminar", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
							/*se toma valor de esta caja de texto */
						producto.setCodigoTablaCategoria(vista.txtCodigoBorrarPorCategoria.getText());
							/* si se encontro ese registro pregunta al usuario si realmente se desea eliminar */
						if (modelo.buscarCategoria(producto) == true) {
							int response = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres Eliminar este Registro?",
									"Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							/* si el usuario acepta eliminar ese registro */
							if (response == JOptionPane.YES_OPTION) {
								/* toma valores del registro que se esta eliminando */
								vista.txtidCategoriaCategoria.setText(String.valueOf(producto.getIdCategoria()));
								producto.setIdCategoria(Integer.parseInt(vista.txtidCategoriaCategoria.getText()));
								/* se elimina ese registro satisfactoriamente */
								if (modelo.eliminarCategoria(producto) == true) {
									JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente.");
									limpiarCajas();
								}
							}
							/* si el usuario no desea eliminar ese registro se limpian las cajas de texto */
							if (response == JOptionPane.NO_OPTION) {
								limpiarCajas();
							}
							/* si no se encuentra registro, muestra mensaje a usuario */
						} else {
							JOptionPane.showMessageDialog(null, "Registro No Encontrado", "Warning",
									JOptionPane.WARNING_MESSAGE);
							limpiarCajas();
						}
					}
				}	
			/* se verifica que haya disponibilidad de ese producto para posteriomente hacer una venta 
			  	del mismo */
		if(botonAcciones.getSource() == vista.btnComprobarDisponibilidad) {
			/* se verifica no queden espacios en blanco por parte del usuario */
			if(String.valueOf(vista.txtCodigoVentas.getText()).compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Debes Indicar Un Registro", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}else {
				/* si no hay espacios en blanco se toma el valor de este elemento */
				producto.setCodigo(vista.txtCodigoVentas.getText());
					/* se busca ese producto para ver si hay en existencia */
				if (modelo.buscar(producto) == true) {
					JOptionPane.showMessageDialog(null, "Platillo Encontrado.");
					limpiarCajas();
					vista.textAreaPerfilPlatillo.setVisible(true);
					vista.lblPerfilPlatillo.setVisible(true);
					/* se activa el boton para hacer una venta de ese producto encontrado */
					vista.btnVender.setVisible(true);
					vista.btnLimpiar.setVisible(true);
					
					/* se muestra el perfil de ese producto encontrado */
					vista.textAreaPerfilPlatillo.setText("IdPRODUCTO: " + String.valueOf(producto.getIdProducto())
					+ "\n\nPLATILLO: " + producto.getPlatillo() + "\n\nREGISTRO: " + producto.getCodigo()
					+ "\n\nPRECIO: " + producto.getPrecio() + "\n\nCANTIDAD: " + producto.getCantidad()
					+ "\n\nIdCATEGORIA: " + producto.getCodigoCategoria() + "\n\nINGREDIENTES: \n"
					+ producto.getIngredientes());
					/* si no se encuentra en existencia ese producto muestra mensaje a usuario */
				}else {
					JOptionPane.showMessageDialog(null, "No Se Encontro Ese Platillo", "Warning",
							JOptionPane.WARNING_MESSAGE);
					limpiarCajas();
				}
			}
		}
		
		
		 /* Boton Vender */
		if(botonAcciones.getSource() == vista.btnVender) {
			/* Esta bandera fue creada para preguntar nuevamente al usuario en caso de error por su parte */
			boolean flag = false;
			
			
			/* Atributo guarda el valor del precio que viene desde la Base de Datos */
			/* Se hace una conversion a flotante ya que el valor original esta como String */
			float precioDataBase = Float.parseFloat(producto.getPrecio());
			
			/* Atributo guarda el valor de la cantidad que viene desde la Base de Datos */
			/* Se hace una conversion a flotante ya que el valor original esta como String */
			float cantidadDataBase = Float.parseFloat(producto.getCantidad());
			
			do {
			flag = false;
			String reciboCantPlatillos = JOptionPane.showInputDialog("¿Cuantos Platillos Necesitas?");
			
			//Conversion a flotante de la cantidad de platillos
			int cantidadPlatillos = Integer.parseInt(reciboCantPlatillos); 
			
			/* se verifica que sea una cantidad valida */
			if(cantidadPlatillos > cantidadDataBase || cantidadPlatillos < 1) {
				JOptionPane.showMessageDialog(null, "Debe Ser Una Cantidad Valida");
				/* si la cantidad no es valida, se vuelve a preguntar al usuario hasta que esta sea acertada
				 	o el usuario decida cancelar la peticion */
				flag = true;
			}else {
				/* si el usuario escogio una cantidad valida, se muestra el precio de ese platillo y lo que
				 	se debe de pagar */
				String reciboPago = JOptionPane.showInputDialog("El Costo Platillo Es: "+precioDataBase
						+"\nA Pagar Es: "+(precioDataBase * cantidadPlatillos)
							+"\nRecibo: ");
				/* variable que almacena el pago hecho por el usuario */
				float pago = Float.parseFloat(reciboPago); 
				
				/* si el usuario paga de menos se retorna a preguntar la cantidad de platillos, esto por si el usuario
				 	deseara cambiar de opinion en cuanto a cantidad de platillos a pedir*/
				if(pago < (precioDataBase * cantidadPlatillos)) {
					JOptionPane.showMessageDialog(null,
							"El Pago Debe Ser: "+(precioDataBase * cantidadPlatillos),"Warning", JOptionPane.WARNING_MESSAGE);
							flag = true; 
				}
				
				
				/* si el usuario paga de mas o da la paga exacta conforme a precio y cantidad de platillos
				 	la paga es aceptada y nos muestra la devolucion de dinero que se debe de hacer en caso 
				 	 que esta sea necesaria */
				if(pago > (precioDataBase * cantidadPlatillos) || pago == (precioDataBase * cantidadPlatillos)) {
					float cambio = (precioDataBase * cantidadPlatillos) - pago;
					cambio = cambio * -1;
					/* se muestra lo que se debe retornar de cambio y se hace la venta */
					JOptionPane.showMessageDialog(null, "Cambio: "+ cambio);
					JOptionPane.showMessageDialog(null, "Venta Completa!");
					float pagoGuardar = (precioDataBase * cantidadPlatillos);	
					
					/* se convierten los valores flotante en String de nuevo para poder almacenarlos nuevamente
					 	en la base de datos */
					String pagoDefinitivo = String.valueOf(pagoGuardar);
					String cantidadPlatillosDefinitiva = String.valueOf(cantidadPlatillos);
					
					/* se habilitan campos y se trata de hacer la insercion de esta venta */
					vista.txtidProductoVentas.setText(String.valueOf(producto.getIdProducto()));
					vista.txtPlatilloVentas.setText(producto.getPlatillo());
					vista.txtCodigoVentasValor.setText(producto.getCodigo());
					vista.txtPagoVentas.setText(pagoDefinitivo);
					vista.txtCantidadaVentas.setText(cantidadPlatillosDefinitiva);
					vista.txtidCategoriaVentas.setText(String.valueOf(producto.getCodigoCategoria()));
						
					producto.setPlatilloVenta(vista.txtPlatilloVentas.getText());	
					producto.setCodigoVenta(vista.txtCodigoVentasValor.getText());
					producto.setPagoVenta(vista.txtPagoVentas.getText());		
					producto.setCantidadVenta(vista.txtCantidadaVentas.getText());		
					producto.setIdCategoriaVenta(vista.txtidCategoriaVentas.getText());				
					
					
					/* resCantidadDB es lo que sobra realmente en flotante para la primer tabla producto*/
					float resCantidadDB = cantidadPlatillos - cantidadDataBase;
					//Si se venden todos los productos se hace operacion para eliminarse el producto de tabla producto
					if(resCantidadDB == 0) {
						producto.setCodigo(vista.txtCodigoVentasValor.getText());
						/*Se buscar el producto que se agoto en ventas para posteriormente eliminarse */
						if (modelo.buscar(producto) == true) {
							/* ya que se encontro dicho producto se toma el id de ese producto para
							 	posteriormente eliminarse */
							vista.txtidProductoVentas.setText(String.valueOf(producto.getIdProducto()));
							producto.setIdProducto(Integer.parseInt(vista.txtidProductoVentas.getText()));
							/* se hace la eliminacion de ese producto ya que se habia vendido por completo */
							if (modelo.eliminar(producto) == true) {
								JOptionPane.showMessageDialog(null, "Platillo Agotado.");
								vista.textAreaPerfilPlatillo.setText("");
							}
						}
					}
					
					
					/* se hace una resta para saber cuantos productos quedaran disponibles en tabla producto
					 	para futuras ventas y para modificarse en la tabla producto*/
					if(resCantidadDB != 0) {
						resCantidadDB = resCantidadDB *-1;
						
						/* se busca ese producto que se acaba de vender */
						producto.setCodigo(vista.txtCodigoVentasValor.getText());
						
						if (modelo.buscar(producto) == true) {
							
							/*Activamos los txt de la tabla producto para tomar su valor tambien, ya que estos no los tenemos en las nuevas cajas */
							vista.textAreaIngredientes.setText(producto.getIngredientes());
							vista.txtPrecio.setText(producto.getPrecio());
							vista.txtidCategoria.setText(String.valueOf(producto.getCodigoCategoria()));
							
							/* convierto el float a string de la resta que se hizo para guardar el valor nuevamente
							 	en la base de datos y lo asigno tambien a una caja de texto para poder mandarlo a la DB */
							String resCantidadDBString = String.valueOf(resCantidadDB);
							vista.txtCantidadRestante.setText(resCantidadDBString);
							
							/* tomamos todas las variables para guardarlas en la DB ya modificadas*/
							producto.setIdProducto(Integer.parseInt(vista.txtidProductoVentas.getText()));
							producto.setPlatillo(vista.txtPlatilloVentas.getText());
							producto.setCodigo(vista.txtCodigoVentasValor.getText());
							producto.setPrecio(vista.txtPrecio.getText());
							producto.setCantidad(vista.txtCantidadRestante.getText()); 
							producto.setIngredientes(vista.textAreaIngredientes.getText()); 
							
							/* se actualiza el registro */
							if (modelo.modificar(producto) == true) {
								JOptionPane.showMessageDialog(null, "Registro Actualizado");
								/* se muestra la actualizacion que se hizo de este registro */
								vista.textAreaPerfilPlatillo.setText("IdPRODUCTO: " + String.valueOf(producto.getIdProducto())
								+ "\n\nPLATILLO: " + producto.getPlatillo() + "\n\nREGISTRO: " + producto.getCodigo()
								+ "\n\nPRECIO: " + producto.getPrecio() + "\n\nCANTIDAD: " + producto.getCantidad()
								+ "\n\nIdCATEGORIA: " + producto.getCodigoCategoria() + "\n\nINGREDIENTES: \n"
								+ producto.getIngredientes());	
							}
						}
					}
					/* se hace el registro de la venta hecha en tabla ventas */
					if(modelo.insertarVentas(producto) == true) {
						JOptionPane.showMessageDialog(null, "Venta Registrada Correctamente.");
						/* en caso de tener un error al insertar en esta tabla muestra mensaje a usuario */
					}else{
		                JOptionPane.showMessageDialog(null,"Error Al Insertar Registro","ERROR",JOptionPane.ERROR_MESSAGE);
		            }
				}
			}
			}while(flag != false);
		}
			/* elimina un registro de tabla ventas */ 
		if (botonAcciones.getSource() == vista.btnEliminarVenta) {
				/* se verifica que el campo no este vacio */
			if (String.valueOf(vista.txtidVentaEliminarVenta.getText()).compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Indica El Id A Eliminar", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}else {
				/* se toma el valor de idVentas para posteriormente buscarlo y si este se encuentra
				 	eliminarlo  */
				producto.setIdVentas(Integer.parseInt(vista.txtidVentaEliminarVenta.getText()));
				/* se busca ese registro y si se encuentra se pregunta a usuario si quiere eliminarlo 
				 	definitivamente */
				if (modelo.buscarVenta(producto) == true) {
					int deleteSale = JOptionPane.showConfirmDialog(null, "¿Seguro Que Quieres Eliminar Esta Venta?",
							"Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					/* si el usuario acepta eliminar este registro */
					if (deleteSale == JOptionPane.YES_OPTION) {
						/* se toma el valor del id del registro de esa venta */
						vista.txtidVentaEliminarVenta.setText(String.valueOf(producto.getIdVentas()));
						producto.setIdVentas(Integer.parseInt(vista.txtidVentaEliminarVenta.getText()));
						/* se elimina ese registro */
						if (modelo.eliminarVenta(producto) == true) {
							JOptionPane.showMessageDialog(null, "Venta Eliminada Correctamente.");
							limpiarCajas();
						}
					}
					/* si el usuario rechaza la eliminacion de ese registro se limpian las cajas de texto */
					if (deleteSale == JOptionPane.NO_OPTION) {
						limpiarCajas();
					}
					/* si la venta que se estaba buscando no se encuentra muestra mensaje al usuario */
				}else {
					JOptionPane.showMessageDialog(null, "Venta No Encontrada", "Warning",
							JOptionPane.WARNING_MESSAGE);
					limpiarCajas();
				}
			}
		}
		/* metodo invocado mediante un boton para limpiar todas las cajas de texto con las que se esten 
		 	trabajando */
		if (botonAcciones.getSource() == vista.btnLimpiar) {
			limpiarCajas();
		}
	}
	/* definicion del metodo para limpiar cajas de texto */
	public void limpiarCajas() {
		vista.txtPlatillo.setText("");
		vista.txtCodigo.setText("");
		vista.txtPrecio.setText("");
		vista.comboBoxCantidad.setSelectedIndex(0);
		vista.textAreaIngredientes.setText("");
		vista.textAreaPerfilPlatillo.setText("");
		vista.txtCategoria.setText("");
		vista.txtidCategoria.setText("");
		vista.textAreaDescripcionCategoria.setText("");
		vista.txtRegistroCodigoCategoria.setText("");
		vista.txtCodigoBorrarPorCategoria.setText("");
		vista.txtCodigoVentas.setText("");
		vista.txtidVentaEliminarVenta.setText("");
	}
}