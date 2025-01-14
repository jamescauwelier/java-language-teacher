package dev.accelerated.language.teacher.domain.id;

import java.util.LinkedList;
import java.util.UUID;

public class HardcodedIdGeneratorAdapter implements IdGeneratorPort {
    private final LinkedList<UUID> ids = new LinkedList<>();

    @Override
    public Id generate() {
        return new Id(ids.removeFirst());
    }

    public HardcodedIdGeneratorAdapter() {
        ids.add(UUID.fromString("01946191-8adb-7997-85d9-6d9279bd0d89"));
        ids.add(UUID.fromString("1946191-8adb-73f1-9b21-662e38ccc151"));
        ids.add(UUID.fromString("1946191-8adb-7c8c-bbae-837727dd8cee"));
        ids.add(UUID.fromString("1946191-8adb-75ae-b503-2af9b2c091d0"));
        ids.add(UUID.fromString("1946191-8adb-7ccb-9503-f1ad053b36a0"));
        ids.add(UUID.fromString("1946191-8adb-7130-bb66-9dfec67814fb"));
        ids.add(UUID.fromString("1946191-8adb-7688-8736-8d518d919a1e"));
        ids.add(UUID.fromString("1946191-8adb-78d9-92ad-0a10e7199dea"));
        ids.add(UUID.fromString("1946191-8adb-7b78-811b-a7652150891a"));
        ids.add(UUID.fromString("1946191-8adb-7530-b01e-94870a20ac28"));
        ids.add(UUID.fromString("1946191-8adb-70f4-92c0-f1484a9ab0bd"));
        ids.add(UUID.fromString("1946191-8adb-70e1-86b3-fa4eb03272d1"));
        ids.add(UUID.fromString("1946191-8adb-7451-a0f0-bd03bf6eaffe"));
        ids.add(UUID.fromString("1946191-8adb-77c4-9399-4073be3c1d73"));
        ids.add(UUID.fromString("1946191-8adb-7e44-8c86-7a083840e408"));
        ids.add(UUID.fromString("1946191-8adb-7783-bdba-4c783f6c686c"));
        ids.add(UUID.fromString("1946191-8adb-7e4e-9d4b-5e0ff15a65da"));
        ids.add(UUID.fromString("1946191-8adb-75ad-84ab-1e3d28ca759e"));
        ids.add(UUID.fromString("1946191-8adb-7649-a632-5f66c7b8c025"));
        ids.add(UUID.fromString("1946191-8adb-727a-ad8e-8240b4ec0210"));
        ids.add(UUID.fromString("1946191-8adb-7c66-a38e-34304fed7a9d"));
        ids.add(UUID.fromString("1946191-8adb-7dcc-bc39-6063be2937e3"));
        ids.add(UUID.fromString("1946191-8adb-755d-85d4-85011d8ffe65"));
        ids.add(UUID.fromString("1946191-8adb-7dbd-8b83-15b40cd39e8e"));
        ids.add(UUID.fromString("1946191-8adb-7916-8dc7-437c36eca3d4"));
        ids.add(UUID.fromString("1946191-8adb-7756-8788-270bd806486d"));
        ids.add(UUID.fromString("1946191-8adb-7f73-893b-0b85bf711c22"));
        ids.add(UUID.fromString("1946191-8adb-778c-b190-f0ee24b3a917"));
        ids.add(UUID.fromString("1946191-8adb-70bb-b145-80a8d7309f36"));
        ids.add(UUID.fromString("1946191-8adb-752e-8683-4496b97a5b6c"));
        ids.add(UUID.fromString("1946191-8adb-72f7-a1a5-b4d2592f2151"));
        ids.add(UUID.fromString("1946191-8adb-74b1-bdb3-2449f4cfe4f4"));
        ids.add(UUID.fromString("1946191-8adb-7c65-bef0-6f19ec662dbf"));
        ids.add(UUID.fromString("1946191-8adb-792a-9537-cf490a157040"));
        ids.add(UUID.fromString("1946191-8adb-7ba9-a19a-ddbd51f04709"));
        ids.add(UUID.fromString("1946191-8adb-7b9e-8de2-ea5c2312557b"));
        ids.add(UUID.fromString("1946191-8adb-7068-9d86-c357eb301d47"));
        ids.add(UUID.fromString("1946191-8adb-7be9-a66a-cd13c37174de"));
        ids.add(UUID.fromString("1946191-8adb-721e-9466-c9b807996d64"));
        ids.add(UUID.fromString("1946191-8adb-75bc-8449-492e0d83e48d"));
        ids.add(UUID.fromString("1946191-8adb-7859-9bc2-27ec9d41e5e1"));
        ids.add(UUID.fromString("1946191-8adb-70eb-86cc-670e51c5338a"));
        ids.add(UUID.fromString("1946191-8adb-7e63-a950-b03be654ae93"));
        ids.add(UUID.fromString("1946191-8adb-7866-a439-c32e716bcaee"));
        ids.add(UUID.fromString("1946191-8adb-713c-9dd5-27df048271ce"));
        ids.add(UUID.fromString("1946191-8adb-7a80-92fb-53c5c11c2072"));
        ids.add(UUID.fromString("1946191-8adb-7c9d-a46e-171b23630e4f"));
        ids.add(UUID.fromString("1946191-8adb-703b-84be-3ac5d301e071"));
        ids.add(UUID.fromString("1946191-8adb-7a4e-9e8b-18a201ce8f24"));
        ids.add(UUID.fromString("1946191-8adb-7051-bea4-a543f276d3df"));
        ids.add(UUID.fromString("1946191-8adb-7274-9760-c3f28b1ca23a"));
        ids.add(UUID.fromString("1946191-8adb-7ead-a3c5-cca3fa6ac531"));
        ids.add(UUID.fromString("1946191-8adb-71bc-a1f0-7c5d8becabfd"));
        ids.add(UUID.fromString("1946191-8adb-7064-8738-f7f4ff54f3a1"));
        ids.add(UUID.fromString("1946191-8adb-7a89-9fa6-65316ca35dab"));
        ids.add(UUID.fromString("1946191-8adb-7e5a-8a26-ad05cb211802"));
        ids.add(UUID.fromString("1946191-8adb-72a6-ab11-f246527bac7a"));
        ids.add(UUID.fromString("1946191-8adb-7815-a947-4b833a120b4d"));
        ids.add(UUID.fromString("1946191-8adb-77c1-841b-234e4d6efc8a"));
        ids.add(UUID.fromString("1946191-8adb-7382-a65b-ee97fefa7356"));
        ids.add(UUID.fromString("1946191-8adb-7fd2-8aa8-30b141b2e85d"));
        ids.add(UUID.fromString("1946191-8adb-7461-9a5e-f03e06e46130"));
        ids.add(UUID.fromString("1946191-8adb-79a2-b64b-167f51208fc5"));
        ids.add(UUID.fromString("1946191-8adb-7d95-ad82-412a592b464a"));
        ids.add(UUID.fromString("1946191-8adb-7e8d-9f43-df28ed7bb358"));
        ids.add(UUID.fromString("1946191-8adb-7638-bf3b-a94dfa23e18d"));
        ids.add(UUID.fromString("1946191-8adb-7375-a617-dde4c46505f2"));
        ids.add(UUID.fromString("1946191-8adb-70ea-922d-df1351b55281"));
        ids.add(UUID.fromString("1946191-8adb-7b5d-a409-a8ff05190056"));
        ids.add(UUID.fromString("1946191-8adb-7122-b290-271a8f5b45b3"));
        ids.add(UUID.fromString("1946191-8adb-7b0b-9ad5-dd31f82187f0"));
        ids.add(UUID.fromString("1946191-8adb-7a70-814b-be91fb66d227"));
        ids.add(UUID.fromString("1946191-8adb-741d-95ad-d16c735af807"));
        ids.add(UUID.fromString("1946191-8adb-752b-987d-f0d2352ac3e1"));
        ids.add(UUID.fromString("1946191-8adb-718e-a961-0db663b4756f"));
        ids.add(UUID.fromString("1946191-8adc-7591-bd9b-de2d71507487"));
        ids.add(UUID.fromString("1946191-8adc-7262-9ac0-5b031e3b32c3"));
        ids.add(UUID.fromString("1946191-8adc-7fbe-869a-816e55c5e8c0"));
        ids.add(UUID.fromString("1946191-8adc-7fc3-a1c2-06f97ea25e07"));
        ids.add(UUID.fromString("1946191-8adc-7a33-a950-86685157e9f1"));
        ids.add(UUID.fromString("1946191-8adc-75f0-bd1c-58d5a4e89e9c"));
        ids.add(UUID.fromString("1946191-8adc-7fad-90af-36faa6535d98"));
        ids.add(UUID.fromString("1946191-8adc-74a4-8fb4-cdad456d99dd"));
        ids.add(UUID.fromString("1946191-8adc-7511-965b-8c8ea5780746"));
        ids.add(UUID.fromString("1946191-8adc-77d8-9718-1eb3eadb2066"));
        ids.add(UUID.fromString("1946191-8adc-79c0-81cd-eff4263f6fdf"));
        ids.add(UUID.fromString("1946191-8adc-7986-ab94-44242ed07e00"));
        ids.add(UUID.fromString("1946191-8adc-7a4b-9377-23a16a4f6cd8"));
        ids.add(UUID.fromString("1946191-8adc-7e89-909b-1e67d317e060"));
        ids.add(UUID.fromString("1946191-8adc-76ca-97d4-d5b1cc865a48"));
        ids.add(UUID.fromString("1946191-8adc-7120-9343-ff00467577c0"));
        ids.add(UUID.fromString("1946191-8adc-7627-989b-ac648a5c3de1"));
        ids.add(UUID.fromString("1946191-8adc-7f1f-8e14-01edeb146932"));
        ids.add(UUID.fromString("1946191-8adc-7553-922d-53bb5673772f"));
        ids.add(UUID.fromString("1946191-8adc-7327-b71e-1226c1803b56"));
        ids.add(UUID.fromString("1946191-8adc-7137-affa-44b0170f689b"));
        ids.add(UUID.fromString("1946191-8adc-7117-a24f-c3cb1ba99e1c"));
        ids.add(UUID.fromString("1946191-8adc-7d52-8c1e-717605d1bdb2"));
        ids.add(UUID.fromString("1946191-8adc-7cc5-ad74-2eff2b3a3aa4"));
        ids.add(UUID.fromString("1946191-8adc-7ce8-a667-f34ac9543be7"));
    }

}
