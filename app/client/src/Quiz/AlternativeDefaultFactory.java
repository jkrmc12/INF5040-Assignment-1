package Quiz;


/**
* Quiz/AlternativeDefaultFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from quiz.idl
* Friday, September 20, 2013 11:55:54 AM CEST
*/


/* Data structure defining one alternative for a Question */
public class AlternativeDefaultFactory implements org.omg.CORBA.portable.ValueFactory {

  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is)
  {
    return is.read_value(new AlternativeImpl ());
  }
}
