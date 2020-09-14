package org.javacodegeeks.springintegration.polling.dbpoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.json.simple.JSONObject;
import org.bson.Document;
import org.jongo.Jongo;

@Component
public class JdbcMessageHandler {

    public void handleJdbcMessage(List<Map<String, Object>> message) throws IOException {

        PndataprocesoDAO pndataprocesoDAO = new PndataprocesoDAO();
//        String concat = "";
        for (Map<String, Object> resultMap : message) {
//            Document dataprocesoJSON = new Document();
            Pndataproceso pndataproceso = new Pndataproceso();
//            System.out.println("------------------------ Object :::::::::::::::::: " + message.toString());

//            JSONObject objAcc = new JSONObject();
            System.out.println("------------------------ Row ------------------------");

            //asign values to JSon object
//            dataprocesoJSON.put("persistenceid", resultMap.get("PERSISTENCEID"));

            pndataproceso.setPersistenceId((BigDecimal) resultMap.get("PERSISTENCEID"));

//            dataprocesoJSON.put("codigoradicador", resultMap.get("CODIGORADICADOR"));
            pndataproceso.setCodigoRadicador((String) resultMap.get("CODIGORADICADOR"));

//            dataprocesoJSON.put("consecutivobonita", resultMap.get("CONSECUTIVOBONITA"));
            pndataproceso.setConsecutivoBonita((BigDecimal) resultMap.get("CONSECUTIVOBONITA"));

//            dataprocesoJSON.put("duraciontotal", resultMap.get("DURACIONTOTAL"));
            try {
                pndataproceso.setDuracionTotal((BigDecimal) resultMap.get("DURACIONTOTAL"));
            } catch (java.lang.NullPointerException npe) {
            }

//            dataprocesoJSON.put("estadoactividad", resultMap.get("ESTADOACTIVIDAD"));
            pndataproceso.setEstadoActividad((String) resultMap.get("ESTADOACTIVIDAD"));

//            dataprocesoJSON.put("fechaasignacionusuario", resultMap.get("FECHAASIGNACIONUSUARIO"));
            try {
                pndataproceso.setFechaAsignacionusuario((BigDecimal) resultMap.get("FECHAASIGNACIONUSUARIO"));
            } catch (java.lang.NullPointerException npe) {
            }

            
//            dataprocesoJSON.put("fechacreacionactividad", resultMap.get("FECHACREACIONACTIVIDAD"));
            try {
                pndataproceso.setFechaCreacionActividad((BigDecimal) resultMap.get("FECHACREACIONACTIVIDAD"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("fechafinalizacionactividad", resultMap.get("FECHAFINALIZACIONACTIVIDAD"));
            try{
            pndataproceso.setFechaFinalizacionActividad((BigDecimal) resultMap.get("FECHAFINALIZACIONACTIVIDAD"));
            } catch (java.lang.NullPointerException npe) { }
            
//            dataprocesoJSON.put("fechainicioactividad", resultMap.get("FECHAINICIOACTIVIDAD"));
            try{
            pndataproceso.setFechaInicioActividad((BigDecimal) resultMap.get("FECHAINICIOACTIVIDAD"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("fechainicioproceso", resultMap.get("FECHAINICIOPROCESO"));
            try{
            pndataproceso.setFechaInicioProceso((BigDecimal) resultMap.get("FECHAINICIOPROCESO"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("fechareinicioactividad", resultMap.get("FECHAREINICIOACTIVIDAD"));
            try{
            pndataproceso.setFechaReinicioActividad((BigDecimal) resultMap.get("FECHAREINICIOACTIVIDAD"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("fechasuspensionactividad", resultMap.get("FECHASUSPENSIONACTIVIDAD"));
            try{
            pndataproceso.setFechaSuspensionActividad((BigDecimal) resultMap.get("FECHASUSPENSIONACTIVIDAD"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("id", resultMap.get("ID"));
            try{
            pndataproceso.setId((BigDecimal) resultMap.get("ID"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("idactividad", resultMap.get("IDACTIVIDAD"));
            try{
            pndataproceso.setIdActividad((BigDecimal) resultMap.get("IDACTIVIDAD"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("idproducto", resultMap.get("IDPRODUCTO"));
            try{
            pndataproceso.setIdProducto((BigDecimal) resultMap.get("IDPRODUCTO"));
            } catch (java.lang.NullPointerException npe) { }
            
//            dataprocesoJSON.put("nocasonegocio", resultMap.get("NOCASONEGOCIO"));
            try{
            pndataproceso.setNocasoNegocio((BigDecimal) resultMap.get("NOCASONEGOCIO"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("nombreactividad", resultMap.get("NOMBREACTIVIDAD"));
            pndataproceso.setNombreActividad((String) resultMap.get("NOMBREACTIVIDAD"));

//            dataprocesoJSON.put("nombreproceso", resultMap.get("NOMBREPROCESO"));
            pndataproceso.setNombreProceso((String) resultMap.get("NOMBREPROCESO"));

//            dataprocesoJSON.put("observaciones", resultMap.get("OBSERVACIONES"));
            pndataproceso.setObservaciones((String) resultMap.get("OBSERVACIONES"));

//            dataprocesoJSON.put("persistenceversion", resultMap.get("PERSISTENCEVERSION"));
            try{
            pndataproceso.setPersistenceVersion((BigDecimal) resultMap.get("PERSISTENCEVERSION"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("proximopaso", resultMap.get("PROXIMOPASO"));
            pndataproceso.setProximoPaso((String) resultMap.get("PROXIMOPASO"));

//            dataprocesoJSON.put("tiempoejecucion", resultMap.get("TIEMPOEJECUCION"));
            try{
            pndataproceso.setTiempoEjecucion((BigDecimal) resultMap.get("TIEMPOEJECUCION"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("tiempoespera", resultMap.get("TIEMPOESPERA"));
            try{
            pndataproceso.setTiempoEspera((BigDecimal) resultMap.get("TIEMPOESPERA"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("usuarioresponsable", resultMap.get("USUARIORESPONSABLE"));
            pndataproceso.setUsuarioResponsable((String) resultMap.get("USUARIORESPONSABLE"));

//            dataprocesoJSON.put("empresa", resultMap.get("EMPRESA"));
            pndataproceso.setEmpresa((String) resultMap.get("EMPRESA"));
            
//            dataprocesoJSON.put("fechavencimientoactividad", resultMap.get("FECHAVENCIMIENTOACTIVIDAD"));
            try{
            pndataproceso.setFechaVencimientoActividad((BigDecimal) resultMap.get("FECHAVENCIMIENTOACTIVIDAD"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("migrated", resultMap.get("MIGRATED"));
            try{
            pndataproceso.setMigrated((BigDecimal) resultMap.get("MIGRATED"));
            } catch (java.lang.NullPointerException npe) { }

//            dataprocesoJSON.put("nocaso", resultMap.get("NOCASO"));
            pndataproceso.setNoCaso((String) resultMap.get("NOCASO"));

//            dataprocesoJSON.put("nombre_proceso", resultMap.get("NOMBRE_PROCESO"));
            pndataproceso.setNombre_proceso((String) resultMap.get("NOMBRE_PROCESO"));

//            dataprocesoJSON.put("multiinstancia", resultMap.get("MULTIINSTANCIA"));
            try{
            pndataproceso.setMultiInstancia((BigDecimal) resultMap.get("MULTIINSTANCIA"));
            } catch (java.lang.NullPointerException npe) { }
            
//            dataprocesoJSON.put("datanegocio", concat);
            pndataproceso.setDataNegocio((String) resultMap.get("DATANEGOCIO"));

            //DATANEGOCIO
//            StringBuffer buffer = new StringBuffer();
//            System.out.println("============================DATANEGOCIO=====================================================");
//            String str = (String) resultMap.get("DATANEGOCIO");
//            for (int i = 0; i < str.length(); i++) {
//                //System.out.print(i+": "+str.charAt(i));
//                //dataprocesoJSON.
//                concat = concat + str.charAt(i);
//                buffer.append("" + (char) str.charAt(i));
//            }
 
            
//            //Jackson
//            Map<String, Object> params = new HashMap<>();
//            params.put("message", "Hello \"Worldee KKK");
//            String payload = new ObjectMapper().writeValueAsString(resultMap);
//
//            dataprocesoJSON.put("payload", payload);

//            String dn = (String) dataprocesoJSON.get("datanegocio");
//            objAcc.put("datanegocioJSON", dataprocesoJSON.get("datanegocio"));
//            byte[] content = dn.getBytes();
//            DataInputStream stream = new DataInputStream(new ByteArrayInputStream(content));
            //                dataprocesoJSON.append("datanegocio", resultMap.get("DATANEGOCIO"));
            //                new Document().append("1", 1);
            //DATANEGOCIO
            //Get all values/columns from a record
//            for (String column : resultMap.keySet()) {
//            }//End for columns
            System.out.println("------------------ INSERT ONE ---------------------------------");
            
//            pndataprocesoDAO.inserOne(dataprocesoJSON);
            pndataprocesoDAO.inserOneJongo(pndataproceso);
            

//            System.out.println(">>>>>>>>>>>>>>JSON Document===> " + dataprocesoJSON.get("datanegocio"));

            System.out.println("------------------------ Row END ---------------------");
        }
//        System.out.println("JONGO");
//        DB db = new MongoClient().getDB("dbname");
//
//        Jongo jongo = new Jongo(db);
//        MongoCollection friends = (MongoCollection) jongo.getCollection("friends");
//        Pndataproceso joe = new Pndataproceso();
//
//        friends.save(joe);
//        joe.age = 28;
//        friends.save(joe);;
        //

    }
}
