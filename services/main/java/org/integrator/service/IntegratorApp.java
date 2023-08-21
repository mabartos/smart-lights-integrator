package org.integrator.service;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.integrator.IntegratorSessionFactory;

import java.util.logging.Logger;

@ApplicationScoped
public class IntegratorApp {

    private static final Logger log = Logger.getLogger(IntegratorApp.class.getName());

    private IntegratorSessionFactory sessionFactory;

    void onStart(@Observes StartupEvent ev) {
        log.info("Starting Smart Street Lights Integrator app...");
        this.sessionFactory = new DefaultIntegratorSessionFactory();
        sessionFactory.init();
        log.info("App started");
    }

    void onShutdown(@Observes ShutdownEvent ev) {
        log.info("Shutting down the app...");
        sessionFactory.shutdown();
        log.info("App almost down");
    }
}
