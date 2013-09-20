package Quiz;


/**
* Quiz/_QuizServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from quiz.idl
* Friday, September 20, 2013 11:55:54 AM CEST
*/


/* Interface for the Quiz Game server object. This interface provides the methods that
	   can be used by clients to play the game.*/
public class _QuizServerStub extends org.omg.CORBA.portable.ObjectImpl implements Quiz.QuizServer
{


  /* Method for the creation of a new question on the server object. The question
  		   object should be created on the client and sent to the server using this method.
  		   On the server, the question is persisted on the memory or disk, so it can be
  		   returned to the clients on future call. The submitted question should be complete,
  		   containing the correct answers. It returns the question id of the created question.
  		   This method should allow the client to select the question id, in case the id is
  		   already taken it should automatically assign an id to the question. Note that a
  		   question may have more than one correct alternatives. */
  public int newQuestion (Quiz.CompleteQuestion question) throws Quiz.QuizServerPackage.QuizException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("newQuestion", true);
                Quiz.CompleteQuestionHelper.write ($out, question);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:Quiz/QuizServer/QuizException:1.0"))
                    throw Quiz.QuizServerPackage.QuizExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return newQuestion (question        );
            } finally {
                _releaseReply ($in);
            }
  } // newQuestion


  /* Returns a question to the client selected randomly form the set of questions stored at
  		   the server. A Question object that does not contains the correct answers is returned. */
  public boolean getRandomQuestion (Quiz.QuestionHolder randomQuestion) throws Quiz.QuizServerPackage.QuizException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getRandomQuestion", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                randomQuestion.value = Quiz.QuestionHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:Quiz/QuizServer/QuizException:1.0"))
                    throw Quiz.QuizServerPackage.QuizExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getRandomQuestion (randomQuestion        );
            } finally {
                _releaseReply ($in);
            }
  } // getRandomQuestion


  /* The client can submit answers to one of the questions that he knows the id. The server
  		   will check the answer and return true if it is correct of false if not. The out correct
  		   parameter should be filled with the write answer. */
  public boolean answerQuestion (int questionId, char[] answer, Quiz.QuizServerPackage.alternativesIdsHolder correct) throws Quiz.QuizServerPackage.QuizException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("answerQuestion", true);
                $out.write_long (questionId);
                Quiz.QuizServerPackage.alternativesIdsHelper.write ($out, answer);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                correct.value = Quiz.QuizServerPackage.alternativesIdsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:Quiz/QuizServer/QuizException:1.0"))
                    throw Quiz.QuizServerPackage.QuizExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return answerQuestion (questionId, answer, correct        );
            } finally {
                _releaseReply ($in);
            }
  } // answerQuestion


  /* Removes a question that has the specified id from the server. */
  public int removeQuestion (int questionId) throws Quiz.QuizServerPackage.QuizException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("removeQuestion", true);
                $out.write_long (questionId);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:Quiz/QuizServer/QuizException:1.0"))
                    throw Quiz.QuizServerPackage.QuizExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return removeQuestion (questionId        );
            } finally {
                _releaseReply ($in);
            }
  } // removeQuestion

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Quiz/QuizServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _QuizServerStub
