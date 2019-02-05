using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class dropCannonball : MonoBehaviour
{
    public GameObject cannonball;
    private Animator openClaw;
    private AudioSource screamAudio;

    // Start is called before the first frame update
    void Start()
    {
       openClaw = GetComponent<Animator>();
       screamAudio = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyUp(KeyCode.Space)){
            Instantiate(cannonball, transform);
            openClaw.SetTrigger("animationTrigger");
        }
    }
    // when collision is detected play audio 
    private void OnCollisionEnter2D(Collision2D collision)
    {
        screamAudio.Play();
    }
}
