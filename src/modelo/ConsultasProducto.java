package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ConsultasProducto extends Conexion {
	PreparedStatement ps;
	ResultSet rs;
	
	/* Inserta en tabla producto */
	public boolean insertar(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("insert into producto (platillo, codigo, precio, cantidad, ingredientes, codigoCategoria) values (?,?,?,?,?,?)");
			ps.setString(1, producto.getPlatillo());
			ps.setString(2, producto.getCodigo());
			ps.setString(3, producto.getPrecio());
			ps.setString(4, producto.getCantidad());
			ps.setString(5, producto.getIngredientes());
			ps.setInt(6, producto.getCodigoCategoria());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex);
			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}
	
	/* Busca en tabla producto */
	public boolean buscar(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("select * from producto where codigo=?");
			ps.setString(1, producto.getCodigo());
			rs = ps.executeQuery();

			if (rs.next() == true) {
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setPlatillo(rs.getString("platillo"));
				producto.setCodigo(rs.getString("codigo"));
				producto.setPrecio(rs.getString("precio"));
				producto.setCantidad(rs.getString("cantidad"));
				producto.setIngredientes(rs.getString("ingredientes"));
				producto.setCodigoCategoria(Integer.parseInt(rs.getString("codigoCategoria")));

				return true;

			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	/* Modificar en tabla producto */
	public boolean modificar(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("update producto set platillo=?, codigo=?, precio=?, cantidad=?, ingredientes=?, codigoCategoria=? where idProducto=?");
			ps.setString(1, producto.getPlatillo());
			ps.setString(2, producto.getCodigo());
			ps.setString(3, producto.getPrecio());
			ps.setString(4, producto.getCantidad());
			ps.setString(5, producto.getIngredientes());
			ps.setInt(6, producto.getCodigoCategoria());
			ps.setInt(7, producto.getIdProducto());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	/* Eliminar en tabla producto */
	public boolean eliminar(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {

			ps = conexion.prepareStatement("delete from producto where idProducto=?");
			ps.setInt(1, producto.getIdProducto());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	/* Insertar en tabla Categoria */
	public boolean insertarCategoria(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("insert into categoria (categoria, codigo, descripcion) values (?,?,?)");
			ps.setString(1, producto.getCategoria());
			ps.setString(2, producto.getCodigoTablaCategoria());
			ps.setNString(3, producto.getDescripcion());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex);
			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}

	}

	/* Buscar por id en tabla categoria */
	public boolean buscarCategoriaPorId(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("select * from categoria where idCategoria=?");
			ps.setInt(1, producto.getIdCategoria());
			rs = ps.executeQuery();

			if (rs.next() == true) {
				producto.setIdCategoria(rs.getInt("idCategoria"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setCodigo(rs.getString("codigo"));
				producto.setDescripcion(rs.getString("descripcion"));

				return true;

			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	/* Buscar en tabla categoria */
	public boolean buscarCategoria(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("select * from categoria where codigo=?");
			ps.setString(1, producto.getCodigoTablaCategoria());
			rs = ps.executeQuery();

			if (rs.next() == true) {
				producto.setIdCategoria(rs.getInt("idCategoria"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setCodigo(rs.getString("codigo"));
				producto.setDescripcion(rs.getString("descripcion"));

				return true;

			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	/* Modificar en tabla categoria */
	public boolean modificarCategoria(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion
					.prepareStatement("update categoria set categoria=?, codigo=?, descripcion=? where idCategoria=?");
			ps.setString(1, producto.getCategoria());
			ps.setString(2, producto.getCodigoTablaCategoria());
			ps.setString(3, producto.getDescripcion());
			ps.setInt(4, producto.getIdCategoria());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	/* Eliminar en tabla categoria */
	public boolean eliminarCategoria(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {

			ps = conexion.prepareStatement("delete from categoria where idCategoria=?");
			ps.setInt(1, producto.getIdCategoria());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}

	}

	/* Insertar en tabla ventas */
	public boolean insertarVentas(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement(
					"insert into ventas (platillo, codigo, pago, cantidad, idCategoria) values (?,?,?,?,?)");
			ps.setString(1, producto.getPlatilloVenta());
			ps.setString(2, producto.getCodigoVenta());
			ps.setString(3, producto.getPagoVenta());
			ps.setString(4, producto.getCantidadVenta());
			ps.setString(5, producto.getIdCategoriaVenta());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex);
			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}

	}

	/* Buscar en tabla ventas */
	public boolean buscarVenta(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("select * from ventas where idVentas=?");
			ps.setInt(1, producto.getIdVentas());
			rs = ps.executeQuery();

			if (rs.next() == true) {
				producto.setIdVentas(rs.getInt("idVentas"));
				producto.setPlatilloVenta(rs.getString("platillo"));
				producto.setCodigoVenta(rs.getString("codigo"));
				producto.setPagoVenta(rs.getString("pago"));
				producto.setCantidadVenta(rs.getString("cantidad"));
				producto.setIdCategoriaVenta(rs.getString("idCategoria"));

				return true;

			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	// Busca si aun hay existencia de ese producto en tabla producto
	public boolean comprobarDisponibilidad(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {
			ps = conexion.prepareStatement("select * from producto where codigo=?");
			ps.setString(1, producto.getCodigo());
			rs = ps.executeQuery();

			if (rs.next() == true) {
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setPlatillo(rs.getString("platillo"));
				producto.setCodigo(rs.getString("codigo"));
				producto.setPrecio(rs.getString("precio"));
				producto.setCantidad(rs.getString("cantidad"));
				producto.setIngredientes(rs.getString("ingredientes"));
				producto.setCodigoCategoria(Integer.parseInt(rs.getString("codigoCategoria")));

				return true;

			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}

	/* Eliminar en tabla ventas */
	public boolean eliminarVenta(ProductoCategoria producto) {
		Connection conexion = getConnection();

		try {

			ps = conexion.prepareStatement("delete from ventas where idVentas=?");
			ps.setInt(1, producto.getIdVentas());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex);

			return false;
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + ex);
			}
		}
	}
}