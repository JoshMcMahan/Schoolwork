using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class movement : MonoBehaviour
{
    public float speed = 10.0f;

    private Rigidbody2D characterBody;

    // Start is called before the first frame update
    void Start()
    {
       characterBody = GetComponent<Rigidbody2D>();

    }

    // Update is called once per frame
    void FixedUpdate()
    {
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");

        Vector2 movementVector = new Vector2(horizontal, vertical);

        characterBody.AddForce(movementVector * speed);


    }
}
