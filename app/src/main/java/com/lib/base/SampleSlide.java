package com.lib.base;

import com.bumptech.glide.Glide;
import com.lib.mydemo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SampleSlide extends Fragment {

	private static final String ARG_LAYOUT_RES_ID = "layoutResId";
	private static final String ARG_IMG_RES_ID = "layoutResId";

	public static SampleSlide newInstance(int layoutResId) {
		SampleSlide sampleSlide = new SampleSlide();

		Bundle args = new Bundle();
		args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
		sampleSlide.setArguments(args);

		return sampleSlide;
	}

	public static SampleSlide newInstanceImg(int img) {
		SampleSlide sampleSlide = new SampleSlide();

		Bundle args = new Bundle();
		args.putInt(ARG_IMG_RES_ID, img);

		sampleSlide.setArguments(args);

		return sampleSlide;
	}

	private int layoutResId;
	private int imgResId;

	public SampleSlide() {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
			layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
		}
		if (getArguments() != null && getArguments().containsKey(ARG_IMG_RES_ID)) {
			imgResId = getArguments().getInt(ARG_IMG_RES_ID);
		}
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view;
		if (getArguments() != null && getArguments().containsKey(ARG_IMG_RES_ID)) {

			view = inflater.inflate(R.layout.intro, null);
			ImageView imageView = (ImageView) view.findViewById(R.id.intro_img);
			imageView.setImageResource(imgResId);
		} else {
			view = inflater.inflate(layoutResId, container, false);
		}

		return view;
	}

}