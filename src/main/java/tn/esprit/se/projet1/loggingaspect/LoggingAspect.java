package tn.esprit.se.projet1.loggingaspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j


    public class LoggingAspect {
        @Before("execution(* tn.esprit.se.projet1.services.BlocService.*(..))")
        public void logMethodEntry(JoinPoint joinPoint) {
            String name = joinPoint.getSignature().getName();
            log.info("In method " + name + " : ");
        }

    @AfterReturning("execution(* tn.esprit.se.projet1.services.EtudiantService.addEtudiant(..))")
    public void logMethodEntryReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In running " + name + " : ");
    }

    @AfterThrowing("execution(* tn.esprit.se.projet1.services.EtudiantService.addEtudiant(..))")
    public void logMethodEntryThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In throwing " + name + " : ");
    }
    @After("execution(* tn.esprit.se.projet1.services.EtudiantService.addEtudiant(..))")
    public void logMethodEntryExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("after Execution " + name + " : ");
    }
    }
