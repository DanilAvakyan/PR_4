package com.example.Rabota.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Specifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty (message = "Поле не может быть пустым")
    @Size(max = 15, message = "Поле не может содержать более 15 символов")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Поле может содержать только английские буквы")
    private String CPU;
    @Min(value = 0, message = "Поле не может содержать отрицательное число!")
    private int RAM;
    @Min(value = 0, message = "Поле не может содержать отрицательное число!")
    private int MemorySize;
    @NotEmpty (message = "Поле не может быть пустым")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Поле может содержать только английские буквы")
    @Size(max = 15, message = "Поле не может содержать более 15 символов")
    private String GPU;
    @NotEmpty (message = "Поле не может быть пустым")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Поле может содержать только английские буквы")
    @Size(max = 15, message = "Поле не может содержать более 15 символов")
    private String OS;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getCPU() {return CPU;}
    public void setCPU(String CPU) {this.CPU = CPU;}


    public int getRAM() {return RAM;}

    public void setRAM(int RAM) {this.RAM = RAM;}


    public int getMemorySize() {return MemorySize;}

    public void setMemorySize(int MemorySize) {this.MemorySize = MemorySize;}


    public String getGPU() {return GPU;}

    public void setGPU(String GPU) {this.GPU = GPU;}


    public String getOS() {return OS;}

    public void setOS(String OS) {this.OS = OS;}


    public Specifications() {}

    public Specifications(String CPU, int RAM, int MemorySize, String GPU, String OS) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.MemorySize = MemorySize;
        this.GPU = GPU;
        this.OS = OS;
    }

}
