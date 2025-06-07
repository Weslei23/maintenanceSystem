package com.wsdev.maintenanceSystem.Models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class AddressModel
{
    @NotBlank
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
    private String postalCode;

    public String getStreet()
    {
        return street;
    }

    public void setStreet( String street )
    {
        this.street = street;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber( String number )
    {
        this.number = number;
    }

    public String getComplement()
    {
        return complement;
    }

    public void setComplement( String complement )
    {
        this.complement = complement;
    }

    public String getNeighborhood()
    {
        return neighborhood;
    }

    public void setNeighborhood( String neighborhood )
    {
        this.neighborhood = neighborhood;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState( String state )
    {
        this.state = state;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode( String postalCode )
    {
        this.postalCode = postalCode;
    }
}

