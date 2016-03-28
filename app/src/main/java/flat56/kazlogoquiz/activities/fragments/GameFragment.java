package flat56.kazlogoquiz.activities.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.LogosActivity;
import flat56.kazlogoquiz.activities.adapters.CharacterGridAdapter;
import flat56.kazlogoquiz.activities.views.AnswerGrid;
import flat56.kazlogoquiz.models.Logo;

public class GameFragment extends Fragment {

    public static final String LOGO_EXTRA = "LOGO_EXTRA";
    private Logo logo;
    private int levelPos;
    private int logoPos;
    private ImageView imageLogo;
    private LinearLayout answerGridCont;
    private GridView charsGrid;
    private AnswerGrid answerGrid;
    private CharacterGridAdapter characterGridAdapter;
    private LinearLayout points;
    private Context context;

    private OnFragmentInteractionListener mListener;

    public GameFragment() {}

    public static GameFragment newInstance(int levelPos, int logoPos) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();

        args.putInt(LogosActivity.LEVEL_EXTRA, levelPos);
        args.putInt(LOGO_EXTRA, logoPos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            levelPos = getArguments().getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = getArguments().getInt(LOGO_EXTRA);
            logo = Dummy.levelList.get(levelPos).getLogos().get(logoPos);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if(context == null)
            context = getActivity().getBaseContext();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        imageLogo = (ImageView) view.findViewById(R.id.imageLogo);
        answerGridCont = (LinearLayout) view.findViewById(R.id.answer_grid);
        charsGrid = (GridView) view.findViewById(R.id.characters_grid);
        points = (LinearLayout) view.findViewById(R.id.points);

        if(savedInstanceState != null){
            levelPos = savedInstanceState.getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = savedInstanceState.getInt(LOGO_EXTRA);
            logo = Dummy.levelList.get(levelPos).getLogos().get(logoPos);
        }

        answerGrid = new AnswerGrid(context, logo.getCorrect());
        characterGridAdapter = new CharacterGridAdapter(context, charsGrid, logo.getChars(), 0);
        characterGridAdapter.setAnswerGrid(answerGrid);
        answerGrid.setCharacterGridAdapter(characterGridAdapter);

        charsGrid.setAdapter(characterGridAdapter);

        fillData();

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void fillData(){
        imageLogo.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.logo_temp));
        for (int i = 0; i < logo.getPoints(); i++) {
            ImageView view = new ImageView(getActivity().getBaseContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 0, 5);
            view.setLayoutParams(params);
            view.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_tenge_medium));
            points.addView(view);

        }
        answerGrid.initAndAddTo(answerGridCont);

    }

}
