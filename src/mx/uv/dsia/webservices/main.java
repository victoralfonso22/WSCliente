package mx.uv.dsia.webservices;

import javax.xml.bind.DatatypeConverter;

import java.sql.*;
import java.util.Collections;

public class main {

	
		
		public static void main(String[] args) throws SQLException{
			WsGetInfSorteoLocator location = new WsGetInfSorteoLocator();
			
			WsGetInfSorteoSoap puerto = null;
			
			String datos = null;
			
			Connection con = null;
			
			ResultSet rs = null;
			
			
		
		try{
			
			con = DriverManager.getConnection(
		            "jdbc:mysql://207.246.241.36/591677_sorteo?"
		            + "user=591677_principal&password=Pagina123");
			
			Statement cmd = con.createStatement();
			
			
			puerto = location.getwsGetInfSorteoSoap();
			
			String mes;
			String dia;
			
			String dato;
			dato ="";
			int tieneRegistro = 0;
			for(int x = 1; x < 12; x++){
				for(int y = 1; y < 31; y++){
					mes="";
					dia="";
					if(String.valueOf(x).length() == 1){
						mes = "0"+String.valueOf(x); 
					}else{
						mes = String.valueOf(x);
					}
					if(String.valueOf(y).length() == 1){
						dia = "0"+String.valueOf(y); 
					}else{
						dia = String.valueOf(y);
					}
					
					
					
					datos = puerto.sorteoUV(dia+"/"+mes+"/"+"2017");
					System.out.println(dia+"/"+mes+"/"+"2017");
					byte[] decoded = DatatypeConverter.parseBase64Binary(datos);
					dato = new String(decoded, "UTF-8");
					
					
					//System.out.println(dato);
					String uno = dato.replaceAll("<NewDataSet>", "").replaceAll("<Table>", "").replaceAll
							("</Table>", "").replaceAll("</NewDataSet>", "").replaceAll("<NewDataSet />", "");
					
					
					uno=uno.trim();
					  uno=uno.replaceAll(" ", "");
					  uno=uno.replaceAll("<NewDataSet/>", "");

					
					String[] unos = uno.split("[\\r\\n]+");
									
					
					for(int i = 0; i < unos.length; i++){
						
						
						unos[i] = unos[i].replaceAll("^\\s*","");
						//System.out.println(unos[i]);
						int a = 7;
						
						String telefono = "",pass = "",linea = "",boletos = "", monto = "", fecha = "",lada = "",tipoTel = "";
						//System.out.println("Valor de i "+i);
						
						
						if (unos[i].length() > 0){
						if(unos[i].contains("<FWBNEPA_PASS>")){
						//	System.out.println("Pass");
							pass =unos[i].replace("<FWBNEPA_PASS>", "").replace("</FWBNEPA_PASS>", "").toString();
							
						//	System.out.println(pass);
						}
						if(unos[i+1].contains("<FWBNEPA_CADENAP>")){
						//	System.out.println("Linea");
							linea =unos[i+1].replace("<FWBNEPA_CADENAP>", "").replace("</FWBNEPA_CADENAP>", "").toString();
						//	System.out.println(linea);
						}
						if(unos[i+2].contains("<FWBNEPA_NUM_BOL>")){
						//	System.out.println("Boletos");
							boletos =unos[i+2].replace("<FWBNEPA_NUM_BOL>", "").replace("</FWBNEPA_NUM_BOL>", "").toString();
						//	System.out.println(boletos);
						}
						if(unos[i+3].contains("<FWBNEPA_MONTO>")){
						//	System.out.println("Monto");
							monto =unos[i+3].replace("<FWBNEPA_MONTO>", "").replace("</FWBNEPA_MONTO>", "").toString();
						//	System.out.println(monto);
						}
						if(unos[i+4].contains("<FWBNEPA_FEC_PAG>")){
						//	System.out.println("Fecha");
							fecha =unos[i+4].replace("<FWBNEPA_FEC_PAG>", "").replace("</FWBNEPA_FEC_PAG>", "").toString();
						//	System.out.println(fecha);
						}
						if(unos[i+5].contains("<LADA>")){
						//	System.out.println("Lada");
							lada =unos[i+5].replace("<LADA>", "").replace("</LADA>", "").toString();
						//	System.out.println(lada);
						}else{
							
						}
						if(unos[i+6].contains("<NUMERO>")){
						//	System.out.println("Telefono");
							telefono =unos[i+6].replace("<NUMERO>", "").replace("</NUMERO>", "").toString();
						//	System.out.println(telefono);
						}else{
							
							a = 5;
						}
						if(unos[i+7].contains("<TIPO_TEL>")){
						//	System.out.println("TipoTel");
							tipoTel =unos[i+7].replace("<TIPO_TEL>", "").replace("</TIPO_TEL>", "").toString();
						//	System.out.println(tipoTel);
						}
						
						
						String numTel = lada+telefono;
						
						
						
								tieneRegistro = 0;
								rs = cmd.executeQuery("select id from registroEstudiantes where lineacaptura = '"+linea+"' and pwd = '"+pass+"'");
								while (rs.next()) {
								    
								    tieneRegistro = rs.getInt(1);
								    System.out.println(tieneRegistro);
								}

							//	System.out.println("insert into registroEstudiantes (lineacaptura,pwd,precio,num_boletos,telefono,tipo_tel) values ('"+unos[i+1]+"','"+unos[i]+"','"+unos[i+3]+"','"+unos[i+2]+"','"+unos[i+5]+"'+'"+unos[i+6]+"','"+unos[i+7]+"')");
								
								if(tieneRegistro == 0){
									
								System.out.println("insert into registroEstudiantes (lineacaptura,pwd,precio,num_boletos,fecha,telefono,tipo_tel) values ('"+linea+"','"+pass+"','"+monto+"','"+boletos+"','"+fecha+"','"+numTel+"','"+tipoTel+"')");
								String sql = "insert into registroEstudiantes (lineacaptura,pwd,precio,num_boletos,fecha,telefono,tipo_tel) values ('"+linea+"','"+pass+"','"+monto+"','"+boletos+"','"+fecha+"','"+numTel+"','"+tipoTel+"')";
								cmd.executeUpdate(sql);
								System.out.println(sql);
								}
								i = i+a;	
							//System.out.println(unos[i]);
							rs.close();
							}
							
						
							
					}
					}
					
			//		System.out.println(dia+"/"+mes+"/"+"2017");
				}
			
			
			
			
		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		
		

	}
	

}

