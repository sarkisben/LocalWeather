package com.example.michael.localweather.Settings;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.michael.localweather.MainActivity;
import com.example.michael.localweather.R;

public class SettingsFragment extends Fragment implements SettingsContract.View{

    private SettingsContract.Presenter presenter;
    private Button backButton;
    private Activity activity;
    private EditText enterLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_fragment, container, false);
        return v;
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        activity = getActivity();
        presenter = new SettingsPresenter(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        RadioGroup allSettings = (RadioGroup) activity.findViewById(R.id.settings);
        backButton = (Button) activity.findViewById(R.id.back_button);
        enterLocation = (EditText) activity.findViewById(R.id.enter_location);
        allSettings.check(R.id.current_location);
        allSettings.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.current_location){
                    enterLocation.setFocusable(false);
                }
                else{
                    enterLocation.setFocusable(true);
                }
            }
        });

        enterLocation.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if(event == null || !event.isShiftPressed()){
                        ((MainActivity)getActivity()).setReadableLocation(v.getText().toString());
                        return true;
                    }
                }
                return false;
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goBack(getFragmentManager());
            }
        });
    }


}
