Spring Boot Admin        
        1. Actuator    
        2. Dropwizard          
        3. Jolokia          
        4. Spring Cloud        
        5. Eureka          
        6. Prometheus          
        7. Grafana  
        8. Grok
        9. Kubernetes    
        10. Tons of plugins :)         
  
start prometheus          
    cd prometheus          
    prometheus          
    http://localhost:9090/          
  
start grafana          
    cd /usr/local/Cellar/grafana/4.6.3/share/grafana/conf          
    grafana-server          
    http://localhost:3000/login          
    admin/admin  
  
start grok:
    ./grok_exporter -config ./config_tofs.yml 
    
start all the three project.