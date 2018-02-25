package ga.nikhilkumar.molaritycalculator;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 * Created by Nikhil on 12/02/2018.
 */

public class StaticMethods {

    //Mass Activity
    static String mass_conc="";
    static String mass_concunit="";
    static String mass_fwt="";
    static String mass_vol="";
    static String mass_volunit="";
    static String mass_res="";

    //Volume Activity
    static String vol_mass="";
    static String vol_massunit="";
    static String vol_fwt="";
    static String vol_conc="";
    static String vol_concunit="";
    static String vol_res="";

    //Molarity Activity
    static String mol_mass="";
    static String mol_massunit="";
    static String mol_fwt="";
    static String mol_vol="";
    static String mol_volunit="";
    static String mol_res="";

    //Dilution Activity
    static String dil_stconc="";
    static String dil_stconcunit="";
    static String dil_dsconc="";
    static String dil_dsconcunit="";
    static String dil_dsvol="";
    static String dil_dsvolunit="";
    static String dil_res="";

    static boolean Demo = false;

    private static String FormatAnswer(float value, String unit, int ndec){
        int factor= (int) Math.pow(10,ndec);
        if (value < Math.pow(10,-9))
        {return( Math.round((value/Math.pow(10,-12)*factor))/factor + "  pico" + unit);}
        else  if (value < Math.pow(10,-6))
        {return( Math.round((value/Math.pow(10,-9))*factor)/factor + "  nano" + unit);}
        else if (value < Math.pow(10,-3))
        {return( Math.round((value/Math.pow(10,-6))*factor)/factor + "  micro" + unit);}
        else if (value < 1)
        {return( Math.round((value/Math.pow(10,-3))*factor)/factor + "  milli" + unit);}
        else   {return(Math.round((value)*factor)/factor + " " + unit);}
    }

    private void ClearResult()
    {
        //Mass Activity
        mass_conc="";
        mass_concunit="";
        mass_fwt="";
        mass_vol="";
        mass_volunit="";
        mass_res="";

        //Volume Activity
        vol_mass="";
        vol_massunit="";
        vol_fwt="";
        vol_conc="";
        vol_concunit="";
        vol_res="";

        //Molarity Activity
        mol_mass="";
        mol_massunit="";
        mol_fwt="";
        mol_vol="";
        mol_volunit="";
        mol_res="";

        //Dilution Activity
        dil_stconc="";
        dil_stconcunit="";
        dil_dsconc="";
        dil_dsconcunit="";
        dil_dsvol="";
        dil_dsvolunit="";
        dil_res="";

        Demo = false;
    }

    public static void CalcMass()
    {
        float conc =parseFloat(mass_conc);
        int units=parseInt(mass_concunit);
        float molar= (float) (conc * Math.pow(10,units));
        float MW = parseFloat(mass_fwt);
        float volume= parseFloat(mass_vol);
        int Vunits=parseInt(mass_volunit);
        float liters= (float) (volume * Math.pow(10,Vunits));
        float moles=liters*molar;
        float grams=moles*MW;
        float mass;
        int munits;

        int factor= (int) Math.pow(10,4);
        if (grams < Math.pow(10,-3))
        {
            mass= Math.round((grams/Math.pow(10,-6))*factor)/factor;
            munits=-6;
        }
        else if (grams < 1)
        {
            mass= Math.round((grams/Math.pow(10,-3))*factor)/factor;
            munits=-3;}
        else
            {
            mass=Math.round((grams)*factor)/factor;
            munits=0;
        }
        vol_fwt= String.valueOf(MW);
        vol_conc=mass_conc;
        vol_concunit= String.valueOf(units);
        vol_mass= String.valueOf(mass);
        vol_massunit= String.valueOf(munits);
        mol_fwt= String.valueOf(MW);
        mol_volunit= String.valueOf(Vunits);
        mol_vol=mass_vol;
        mol_mass= String.valueOf(mass);
        mol_massunit= String.valueOf(munits);
        String answer;
        if (Demo) {answer = "Not registered.";}
        else {answer = FormatAnswer(grams,"grams",4);}
        mass_res=answer;
    }



    public static void CalcVolume()
    {
        float mass =parseFloat(vol_mass);
        int units=parseInt(vol_massunit);
        float grams= (float) (mass * Math.pow(10,units));
        float MW = parseFloat(vol_fwt);
        float conc= parseFloat(vol_conc);
        int Cunits=parseInt(vol_concunit);
        float molar= (float) (conc * Math.pow(10,Cunits));
        float moles=grams/MW;
        float liters=moles/molar;
        mol_fwt= String.valueOf(MW);
        mol_mass=vol_mass;
        mol_massunit=vol_massunit;
        String answer;
        if (Demo) {answer = "Not registered.";}
        else {answer = FormatAnswer(liters,"liter",4);}
        vol_res=answer;
    }

    public static void CalcMolarity()
    {
        float mass =parseFloat(mol_mass);
        int units=parseInt(mol_massunit);
        mass= (float) (mass * Math.pow(10,units));
        float MW = parseFloat(mol_fwt);
        float volume= parseFloat(mol_vol);
        int Vunits=parseInt(mol_volunit);
        float liters= (float) (volume * Math.pow(10,Vunits));
        float moles=mass/MW;
        float molar=moles/liters;
        String answer;
        if (Demo) {answer = "Not registered.";}
        else {answer = FormatAnswer(molar,"molar",4);}
        mol_res=answer;
    }

    public static void Dilute()
    {
        float dconc =parseFloat(dil_dsconc);
        int dunits=parseInt(dil_dsconcunit);
        float dmolar= (float) (dconc * Math.pow(10,dunits));
        float sconc =parseFloat(dil_stconc);
        int sunits=parseInt(dil_stconcunit);
        float smolar= (float) (sconc * Math.pow(10,sunits));
        float volume= parseFloat(dil_dsvol);
        int Vunits=parseInt(dil_dsvolunit);
        float liters= (float) (volume * Math.pow(10,Vunits));
        float LitersNeeded= dmolar/smolar * liters;
        String answer;
        if (Demo) {answer = "Not registered.";}
        else
            if (dmolar > smolar) {answer = "Impossible.";}
            else
                {answer = FormatAnswer(LitersNeeded,"liter",4);}
        dil_res=answer;
    }
}
