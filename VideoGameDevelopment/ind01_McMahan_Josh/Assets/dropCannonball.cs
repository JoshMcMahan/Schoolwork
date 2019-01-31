using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class dropCannonball : MonoBehaviour
{
    public GameObject cannonball;
    private Animator openClaw;

    // Start is called before the first frame update
    void Start()
    {
       openClaw = GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyUp(KeyCode.Space)){
            Instantiate(cannonball, transform);
            openClaw.SetTrigger("animationTrigger");
        }
    }
}
