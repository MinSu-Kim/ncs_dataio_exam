package ncs_dataio_exam.exception;

@SuppressWarnings("serial")
public class DuplicateEmployeeException extends RuntimeException {

    public DuplicateEmployeeException(String message) {
        super(message);
    }

}
