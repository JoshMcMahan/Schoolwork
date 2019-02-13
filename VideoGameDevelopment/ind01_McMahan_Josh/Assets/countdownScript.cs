﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class countdownScript : MonoBehaviour
{
    [SerializeField] private Text uiText;
    [SerializeField] private float mainTimer;

    private float timer;
    private bool canCount = true;
    private bool doOnce = false;

    private void Start()
    {
        timer = mainTimer;
    }

    private void Update()
    {
        if((uiText != null) && (timer >= 0.0f && canCount))
        {
            timer -= Time.deltaTime;
            uiText.text = timer.ToString("F");
        }

        else if((uiText != null) && (timer <= 0.0f && !doOnce))
        {
            canCount = false;
            doOnce = true;
            uiText.text = "0.00";
            timer = 0.0f;

        }
    }

}
