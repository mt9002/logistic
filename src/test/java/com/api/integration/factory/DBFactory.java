package com.api.integration.factory;

import com.api.domain.interfaces.outgoing.jpaORM.IAuthORM;
import com.api.domain.interfaces.outgoing.jpaORM.IDeliveryDepositORM;
import com.api.domain.interfaces.outgoing.jpaORM.IDeliveryDepositVehicleORM;
import com.api.domain.interfaces.outgoing.jpaORM.IDispatchORM;
import com.api.domain.interfaces.outgoing.jpaORM.ILogisticORM;
import com.api.domain.interfaces.outgoing.jpaORM.IProductORM;
import com.api.domain.interfaces.outgoing.jpaORM.IVehicleORM;
import com.api.domain.models.Dispatch;
import com.api.domain.models.Logistic;
import com.api.domain.models.Vehicle;
import com.api.domain.models.auth.Client;
import com.api.domain.models.deposit.DeliveryDeposit;
import com.api.domain.models.deposit.DeliveryDepositVehicle;
import com.api.domain.models.product.Product;
import com.api.domain.models.product.ProductQuantity;
import com.api.domain.services.dispatch.mapper.DispatchMapper;
import com.api.domain.utils.enums.DeliveryDepositType;
import com.api.domain.utils.enums.TypeLogistic;
import com.api.domain.utils.enums.VehicleIdentifierType;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DBFactory {
    
    @Autowired
    public DBFactory(IAuthORM authRepository,
            IVehicleORM iVehicleORM,
            IProductORM productORM, 
            ILogisticORM logisticORM, IDispatchORM dispatchORM,
            IDeliveryDepositVehicleORM DeliveryDepositVehicleORM,
            IDeliveryDepositORM DeliveryDepositORM,
            DispatchMapper dispatchMapper
    
    ) {
        this.authRepository = authRepository;
        this.iVehicleORM = iVehicleORM;
        this.productORM = productORM;
        this.logisticORM = logisticORM;
        this.dispatchORM = dispatchORM;
        this.DeliveryDepositVehicleORM = DeliveryDepositVehicleORM;
        this.DeliveryDepositORM = DeliveryDepositORM;
        this.dispatchMapper = dispatchMapper;
    }

    
    private final IAuthORM authRepository;
    private final IVehicleORM iVehicleORM;
    private final IProductORM productORM;
    private final ILogisticORM logisticORM;
    private final IDispatchORM dispatchORM;
    private final IDeliveryDepositVehicleORM DeliveryDepositVehicleORM;
    private final IDeliveryDepositORM DeliveryDepositORM;
    private final DispatchMapper dispatchMapper;

    public Client createClient() {
        Faker fairy = new Faker();
        
        Client client = new Client(
                fairy.name().firstName(),
                fairy.name().lastName(),
                fairy.internet().emailAddress(),
                "ma1234567"
        );

        Client clientSave = authRepository.save(client);
        return clientSave;
    }

    public Logistic createLogistic() {
        Set<ProductQuantity> productQuantities = new HashSet<>();
        Logistic logistic = new Logistic(
                TypeLogistic.valueOf("LAND"),
                productQuantities,
                DeliveryDepositFactory.deliveryDeposit(),
                23D,
                33F 
        );

        Logistic savedLogistic = logisticORM.save(logistic);
        return savedLogistic;
    }

    public Dispatch createDispatch() {
        Dispatch logistic = new Dispatch(
                UserFactory.createUser(),
                LogisticFactory.createLogistic(),
                dispatchMapper.generateTrackingNumber()
        );

        Dispatch dispatchSave = dispatchORM.save(logistic);
        return dispatchSave;
    }

    public Product createProduct() {
        Faker fairy = new Faker();
        Product product = new Product(
                fairy.lorem().paragraph(),
                "Tecnologia",
                "1 metro",
                15000f
        ); 
        Product productSave = productORM.save(product);
        return productSave;
    }

    public DeliveryDeposit createDeliveryDeposit(long id_vehicle) {
        Set<DeliveryDepositVehicle> setDeliveryDepositVehicle = new HashSet<>();

        Vehicle vehicle = new Vehicle();
        vehicle.setId(id_vehicle);

        DeliveryDepositVehicle deliveryDepositVehicle = new DeliveryDepositVehicle();
        deliveryDepositVehicle.setVehicle(vehicle);
        setDeliveryDepositVehicle.add(deliveryDepositVehicle);

        DeliveryDeposit deliveryDeposit = new DeliveryDeposit(
                DeliveryDepositType.valueOf("WAREHOUSE"),
                setDeliveryDepositVehicle,
                "MarujaDeposit"
        );
        var deliveryDepositSave = DeliveryDepositORM.save(deliveryDeposit);
        return deliveryDepositSave;
    }

    public DeliveryDepositVehicle createDeliveryDepositVehicle() {
        DeliveryDepositVehicle deliveryDepositVehicle = new DeliveryDepositVehicle(
                DeliveryDepositFactory.deliveryDeposit(),
                VehicleFactory.vehicle()
        );
        var deliveryDepositVehicleSave = DeliveryDepositVehicleORM.save(deliveryDepositVehicle);
        return deliveryDepositVehicleSave;
    }

    public Vehicle createVehicle() {
        Vehicle vehicle = new Vehicle(
                VehicleIdentifierType.valueOf("PLACA"),
                "VAZ133",
                "Kia"
        );
        var vehicleSave = iVehicleORM.save(vehicle);
        return vehicleSave;
    }
}
