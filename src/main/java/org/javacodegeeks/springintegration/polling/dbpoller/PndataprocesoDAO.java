package org.javacodegeeks.springintegration.polling.dbpoller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.jongo.Jongo;
import org.json.simple.JSONObject;

public class PndataprocesoDAO {

    final MongoClient mongoClient;
    final MongoDatabase database;
    private final MongoCollection<Document> customersCollection;

    //
    protected DBCollection collection;
    protected DB db;
    public static final String collectionName = "pndataproceso";

    public PndataprocesoDAO() {

        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
        database = mongoClient.getDatabase("test");
        customersCollection = database.getCollection("pndataproceso");
    }

    public String inserOneJongo(Pndataproceso pndataproceso) {

        String result = "success";
        System.out.println("inserOneJongo.inserting pnDataproceso entry ");
        db = mongoClient.getDB("test");

        Jongo jongo = new Jongo(db);
        org.jongo.MongoCollection pndataprocesos = jongo.getCollection("pndataproceso");
        try {
            pndataprocesos.insert("{persistenceId: " + pndataproceso.getPersistenceId() + ", codigoradicador: '" + pndataproceso.getCodigoRadicador()
                    + "' , consecutivobonita: " + pndataproceso.getConsecutivoBonita() + " , datanegocio: " + pndataproceso.getDataNegocio()
                    + " ,duraciontotal: " + pndataproceso.getDuracionTotal() + " ,estadoactividad: '" + pndataproceso.getEstadoActividad() + "'"
                    + " ,fechaasignacionusuario: " + pndataproceso.getFechaAsignacionusuario() + ",fechacreacionactividad: " + pndataproceso.getFechaCreacionActividad()
                    + " ,fechafinalizacionactividad: " + pndataproceso.getFechaFinalizacionActividad() + ",fechainicioactividad:  " + pndataproceso.getFechaInicioActividad()
                    + " ,fechainicioproceso: " + pndataproceso.getFechaInicioProceso() + ",fechareinicioactividad: " + pndataproceso.getFechaReinicioActividad()
                    + " ,fechasuspensionactividad: " + pndataproceso.getFechaSuspensionActividad() + ",id: " + pndataproceso.getId()
                    + " ,idactividad: " + pndataproceso.getIdActividad() + ",idproducto: " + pndataproceso.getIdProducto()
                    + " ,nocasonegocio: " + pndataproceso.getNocasoNegocio() + ",nombreactividad: '" + pndataproceso.getNombreActividad() + "'"
                    + " ,nombreproceso: '" + pndataproceso.getNombreProceso() + "' ,observaciones: '" + pndataproceso.getObservaciones() + "'"
                    + " ,persistenceversion: " + pndataproceso.getPersistenceVersion() + ",proximopaso: '" + pndataproceso.getProximoPaso() + "'"
                    + " ,tiempoejecucion: " + pndataproceso.getTiempoEjecucion() + ",tiempoespera: " + pndataproceso.getTiempoEspera()
                    + " ,usuarioresponsable: '" + pndataproceso.getUsuarioResponsable() + "',empresa: '" + pndataproceso.getEmpresa() + "'"
                    + " ,fechavencimientoactividad: " + pndataproceso.getFechaVencimientoActividad() + ",migrated: " + pndataproceso.getMigrated()
                    + " ,nocaso: '" + pndataproceso.getNoCaso() + "',nombre_proceso: '" + pndataproceso.getNombre_proceso() + "',multiinstancia: " + pndataproceso.getMultiInstancia()
                    + " }");
        } catch (com.mongodb.MongoWriteException e) {
            result = "PndataprocesoDAO.inserOneJongo.Exception: " + e;
            System.err.println("Error inserOneJongo pnDataproceso: " + e);
        }

        return result;
    }

    public String inserOne(Document pnDataproceso) {

        String result = "success";
        System.out.println("inserting pnDataproceso entry ");

        try {
            customersCollection.insertOne(pnDataproceso);
            System.out.println("Inserting user pnDataproceso.");
        } catch (com.mongodb.MongoWriteException e) {
            result = "PndataprocesoDAO.inserOne.Exception: " + e;
            System.err.println("Error inserting pnDataproceso: " + e);
        }
//        finally {
//            mongoClient.close();
//        }
        return result;

    }

    public String inserOneJSON(JSONObject jSONObject) {

        String result = "success";
        System.out.println("inserting pnDataproceso entry ");
        Document document = new Document();
        document.append("data", jSONObject);

        try {
//            customersCollection.insertOne(addrObj);
            System.out.println("Inserting user pnDataproceso.");
        } catch (com.mongodb.MongoWriteException e) {
            result = "PndataprocesoDAO.inserOne.Exception: " + e;
            System.err.println("Error inserting pnDataproceso: " + e);
        }
//        finally {
//            mongoClient.close();
//        }
        return result;

    }

}
