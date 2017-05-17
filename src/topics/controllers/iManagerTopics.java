
  package topics.controllers;

  import java.rmi.*;
import topics.models.Concept;
import topics.models.Topic;
/**
 *
 * @author Milka
 */


public interface iManagerTopics extends Remote{
  //Topics
  Topic readTopic(int id) throws RemoteException;
  Topic modifyTopic(int id) throws RemoteException;
  Topic deleteTopic(int id) throws RemoteException;
  Topic createTopic(Topic topic) throws RemoteException;

  //Concept
  Concept readConcept(int id) throws RemoteException;
  Concept modifyConcept(int id) throws RemoteException;
  Concept deleteConcept(int id) throws RemoteException;
  Concept createConcept(Concept concept) throws RemoteException;
}
