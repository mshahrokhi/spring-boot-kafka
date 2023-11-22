//package com.shahrokhi.springbootkafka.config;
//
//public class config {
//    private static final String KAFKA_BOOTSTRAP_SERVERS = "localhost:9092";
//
//    // Producer configuration
//    @Bean
//    public ProducerFactory<String, CustomObject1> customObject1ProducerFactory() {
//        return new DefaultKafkaProducerFactory<>(customObject1ProducerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, CustomObject1> customObject1KafkaTemplate() {
//        return new KafkaTemplate<>(customObject1ProducerFactory());
//    }
//
//    @Bean
//    public ProducerFactory<String, CustomObject2> customObject2ProducerFactory() {
//        return new DefaultKafkaProducerFactory<>(customObject2ProducerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, CustomObject2> customObject2KafkaTemplate() {
//        return new KafkaTemplate<>(customObject2ProducerFactory());
//    }
//
//    // Consumer configuration
//    @Bean
//    public ConsumerFactory<String, CustomObject1> customObject1ConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(customObject1ConsumerConfigs());
//    }
//
//    @Bean
//    public ConsumerFactory<String, CustomObject2> customObject2ConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(customObject2ConsumerConfigs());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, CustomObject1> customObject1KafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, CustomObject1> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(customObject1ConsumerFactory());
//        return factory;
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, CustomObject2> customObject2KafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, CustomObject2> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(customObject2ConsumerFactory());
//        return factory;
//    }
//
//    // Kafka admin to create topics
//    @Bean
//    public NewTopic customObject1Topic() {
//        return new NewTopic("customObject1Topic", 1, (short) 1);
//    }
//
//    @Bean
//    public NewTopic customObject2Topic() {
//        return new NewTopic("customObject2Topic", 1, (short) 1);
//    }
//
//    // Common configurations
//    private Map<String, Object> commonProducerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put("bootstrap.servers", KAFKA_BOOTSTRAP_SERVERS);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.springframework.kafka.support.serializer.ErrorHandlingSerializer");
//        return props;
//    }
//
//    private Map<String, Object> customObject1ProducerConfigs() {
//        Map<String, Object> props = commonProducerConfigs();
//        // Add specific configurations for CustomObject1 producer if needed
//        return props;
//    }
//
//    private Map<String, Object> customObject2ProducerConfigs() {
//        Map<String, Object> props = commonProducerConfigs();
//        // Add specific configurations for CustomObject2 producer if needed
//        return props;
//    }
//
//    private Map<String, Object> commonConsumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put("bootstrap.servers", KAFKA_BOOTSTRAP_SERVERS);
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.springframework.kafka.support.serializer.ErrorHandlingDeserializer2");
//        return props;
//    }
//
//    private Map<String, Object> customObject1ConsumerConfigs() {
//        Map<String, Object> props = commonConsumerConfigs();
//        // Add specific configurations for CustomObject1 consumer if needed
//        props.put("group.id", "customObject1Group");
//        return props;
//    }
//
//    private Map<String, Object> customObject2ConsumerConfigs() {
//        Map<String, Object> props = commonConsumerConfigs();
//        // Add specific configurations for CustomObject2 consumer if needed
//        props.put("group.id", "customObject2Group");
//        return props;
//    }
//}
