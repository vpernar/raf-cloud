package rs.raf.domaci3.services;

import org.springframework.stereotype.Service;
import rs.raf.domaci3.model.ErrorMessage;
import rs.raf.domaci3.model.Operation;
import rs.raf.domaci3.model.User;
import rs.raf.domaci3.repositories.ErrorMessageRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ErrorMessageService {

    private final ErrorMessageRepository errorMessageRepository;

    public ErrorMessageService(ErrorMessageRepository errorMessageRepository) {
        this.errorMessageRepository = errorMessageRepository;
    }

    public void saveErrorMessage(Operation operation, Long nodeId, User user) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setNodeId(nodeId);
        errorMessage.setUser(user);
        errorMessage.setDate(new Date(Calendar.getInstance().getTime().getTime()));
        switch (operation) {
            case START:
                errorMessage.setStatus(Operation.START);
                errorMessage.setMessage("Failed to start node");
                errorMessageRepository.save(errorMessage);
                break;
            case STOP:
                errorMessage.setStatus(Operation.STOP);
                errorMessage.setMessage("Failed to stop machine");
                errorMessageRepository.save(errorMessage);
                break;
            case RESTART:
                errorMessage.setStatus(Operation.RESTART);
                errorMessage.setMessage("Failed to restart machine");
                errorMessageRepository.save(errorMessage);
                break;
            default:

        }
    }

    public List<ErrorMessage> findAllByUser(User user){
        return errorMessageRepository.findAllByUserId(user.getId());
    }
}
