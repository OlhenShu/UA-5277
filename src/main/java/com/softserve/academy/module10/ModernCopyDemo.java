package com.softserve.academy.module10;

public class ModernCopyDemo {

    private static Device buildSampleDevice() {
        Battery battery = new Battery("Li-ion", 80);
        return new Device("Smartphone", battery);
    }

    private static Device buildModifiedDevice(Device originalDevice) {
        Battery modifiedBattery = originalDevice.battery
                .withCharge(100);
        return originalDevice
                .withBattery(modifiedBattery)
                .withModel("Smartphone Pro");
    }

    public static void main(String[] args) {
        Device originalDevice = buildSampleDevice();
        System.out.println("Original Device: " + originalDevice);

        Device modifiedDevice = buildModifiedDevice(originalDevice);
        System.out.println("Modified Device: " + modifiedDevice);
    }

    record Battery(String type, int chargePercent) {
        Battery withCharge(int newChargePercent) {
            return new Battery(type, newChargePercent);
        }
    }

    static final class Device {
        private final String model;
        private final Battery battery;

        Device(String model, Battery battery) {
            this.model = model;
            this.battery = battery;
        }

        Device(Device other) {
            this.model = other.model;
            this.battery = other.battery;
        }

        Device withBattery(Battery newBattery) {
            return new Device(model, newBattery);
        }

        Device withModel(String newModel) {
            return new Device(newModel, this.battery);
        }

        @Override
        public String toString() {
            return "Device{" +
                    "model='" + model + '\'' +
                    ", battery=" + battery +
                    '}';
        }
    }
}
