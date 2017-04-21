# IMT.Units
Units of Measure for Java and Android.
* Type-safe units of measure (Compile time).
* Fast and efficient:
  * Lazy conversion.
  * Conversion with one multiplication, no division.
* Easy to extend.

## Usage
```Java
public class Example {
    public void pressureUnit() { 
        Pressure pressure = new Pressure(1.01325d, PressureUnit.bar);
        System.out.println("Pressure in bar: " + pressure.getValue(PressureUnit.bar));
        System.out.println("Pressure in millibar: " + pressure.getValue(PressureUnit.mbar));
        System.out.println("Pressure in inch H2O : " + pressure.getValue(PressureUnit.inH2O));
 
        // set new value and new unit
        pressure.set(760.0d, PressureUnit.mmHg);
        System.out.println("Pressure in millimeter of mercury: " + pressure.getValue(PressureUnit.mmHg));
        System.out.println("Pressure in bar: " + pressure.getValue(PressureUnit.bar));
        System.out.println("Pressure in millibar: " + pressure.getValue(PressureUnit.mbar));
        System.out.println("Pressure in inch H2O : " + pressure.getValue(PressureUnit.inH2O));
 
        // update value - same unit
        pressure.update(750.0d);
        System.out.println("Pressure in millimeter of mercury: " + pressure.getValue(PressureUnit.mmHg));
        System.out.println("Pressure in bar: " + pressure.getValue(PressureUnit.bar));
        System.out.println("Pressure in millibar: " + pressure.getValue(PressureUnit.mbar));
        System.out.println("Pressure in inch H2O : " + pressure.getValue(PressureUnit.inH2O));
    }
}
```

# Download
## Maven
(coming soon)
## Gradle
(coming soon)
# License
Copyright (c) 2017, IMT Information Management Technology AG  
IMT.Units is licensed under the [BSD 3-clause](LICENSE)
