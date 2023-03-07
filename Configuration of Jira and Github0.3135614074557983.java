
@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    private ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @PostMapping("/jira-github")
    public ResponseEntity configureJiraAndGithub(@RequestBody Configuration config) {
        configurationService.configureJiraAndGithub(config);
        return ResponseEntity.ok().build();
    }

}

@Service
public class ConfigurationService {

    private ConfigurationRepository configurationRepository;

    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public void configureJiraAndGithub(Configuration config) {
        configurationRepository.save(config);
    }

}

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

}

public class Configuration {

    private String jiraCredentials;
    private String githubCredentials;

    // getters and setters

}