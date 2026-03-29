package lld.carRentalSystem;

import lld.carRentalSystem.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CarRentalSystem {

    private final ConcurrentHashMap<Long, CarRentalStore> storeMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, User> userMap = new ConcurrentHashMap<>();

    public void addStore(CarRentalStore store) {
        storeMap.put(store.getStoreId(), store);
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public CarRentalStore getStoreById(long storeId) {
        return storeMap.get(storeId);
    }

    public List<CarRentalStore> getStoresByCity(String city) {
        return storeMap.values().stream()
                .filter(s -> s.getLocation().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public User getUserById(long userId) {
        return userMap.get(userId);
    }
}
