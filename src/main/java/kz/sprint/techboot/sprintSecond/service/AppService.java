package kz.sprint.techboot.sprintSecond.service;

import kz.sprint.techboot.sprintSecond.repository.ApplicationRepository;
import kz.sprint.techboot.sprintSecond.model.ApplicationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {

    private final ApplicationRepository applicationRepository;

    public List<ApplicationRequest> getApps(){
        return applicationRepository.findAllByOrderByHandled();
    }

    public ApplicationRequest addApps(ApplicationRequest appRequest){
        appRequest.setHandled(false);
        return applicationRepository.save(appRequest);
    }

    public ApplicationRequest getApp(Long id){
        return applicationRepository.findById(id).orElse(null);
    }

    public void handledApp(ApplicationRequest appRequest){
        appRequest.setHandled(true);
        applicationRepository.save(appRequest);
    }

    public void deleteApp(Long id){
        applicationRepository.deleteById(id);
    }

}
