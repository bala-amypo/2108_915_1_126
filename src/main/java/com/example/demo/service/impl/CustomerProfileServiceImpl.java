@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {
    private final CustomerProfileRepository repository;
    public CustomerProfileServiceImpl(CustomerProfileRepository repository) { this.repository = repository; }
    // ... implement methods
}