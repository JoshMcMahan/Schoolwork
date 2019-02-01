﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class onHit : MonoBehaviour
{
    private AudioSource screamAudio;
    private int numberOfHits = 0;

    // Start is called before the first frame update
    void Start()
    {
        screamAudio = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    // when collision is detected play audio 
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "undertale" && numberOfHits <1)
        {
            screamAudio.Play();

        }
        numberOfHits++;
    }
}
