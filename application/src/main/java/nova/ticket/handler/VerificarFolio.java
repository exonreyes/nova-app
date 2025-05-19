package nova.ticket.handler;

import lombok.RequiredArgsConstructor;
import nova.UseCase;
import nova.commons.Executor;
import nova.ticket.TicketPersistencePort;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VerificarFolio implements Executor<Boolean, String> {
    private final TicketPersistencePort port;

    @Override
    public Boolean execute(String params) {
        return port.existeFolio(params);
    }
}
