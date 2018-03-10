package ga.nikhilkumar.molaritycalculator;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MassFragment extends Fragment {
EditText massconc,massfwt,massvol;
Spinner massconcunit,massvolunit;
Button calcmass;
TextView massres;

    public MassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mass, container, false);
        getActivity().setTitle("Mass");

        massconc=(EditText) v.findViewById(R.id.mass_conc);
        massfwt=(EditText) v.findViewById(R.id.mass_fwt);
        massvol=(EditText) v.findViewById(R.id.mass_vol);
        massconcunit=(Spinner) v.findViewById(R.id.mass_concunit);
        massvolunit=(Spinner) v.findViewById(R.id.mass_volunit);
        calcmass=(Button) v.findViewById(R.id.calc_mass);
        massres=(TextView) v.findViewById(R.id.mass_res);

        calcmass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StaticMethods.mass_conc= String.valueOf(massconc.getText());
                StaticMethods.mass_fwt= String.valueOf(massfwt.getText());
                StaticMethods.mass_vol= String.valueOf(massvol.getText());
                StaticMethods.mass_volunit="-3";
                StaticMethods.mass_concunit="-3";
                StaticMethods.ClearResult();
                StaticMethods.CalcMass();
                StaticMethods.Demo=true;
            }
        });
        return v;
    }

}
