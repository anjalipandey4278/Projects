
import { useDispatch, useSelector } from "react-redux";
import { addNewPost,reset } from "./postsSlice";
import { useNavigate } from "react-router-dom";
import Base from "../Base";
import { Card, CardBody, Form, Input, Label, Button, Container } from "reactstrap"
import JoditEditor from "jodit-react"
import { useRef } from "react"
import { useState } from "react";
import React from 'react';



const AddPostForm = () => {

     const editor = useRef(null)
    const dispatch = useDispatch()

    const navigate = useNavigate()
    
    const [title, setTitle] = useState('')
    const [content, setContent] = useState('')
    const [addRequestStatus, setAddRequestStatus] = useState('idle')



    const onTitleChanged = e => setTitle(e.target.value)
    const onContentChanged = e => {
        let a = e.replace( /(<([^>]+)>)/ig, '')
        console.log(a)
        setContent(a)
    }
    
    const canSave = [title, content].every(Boolean) && addRequestStatus === 'idle';

    const onSavePostClicked = () => {
        if (canSave) {
            try {
                setAddRequestStatus('pending')
                dispatch(addNewPost({ title, body: content })).unwrap()

                setTitle('')
                setContent('')
                navigate('/')
            } catch (err) {
                console.error('Failed to save the post', err)
            } finally {
                setAddRequestStatus('idle')
            }
        }

    }
    const resetAll = () => {
        setTitle("");
        setContent("");
        dispatch(reset());
    }

    return (
        <section>
            <Base>
        <div className="wrapper">
            <Card className="shadow-sm  border-0 mt-2">
    <CardBody>
               
                 <h3>What going in your mind ?</h3>
                <Form >
                       <div className="my-3">
                           <Label for="title" >Post title</Label>
                           <Input
                               type="text"
                               id="postTitle"
                               name="postTitle"
                               value={title}
                               onChange={onTitleChanged}
                               
                            />
                          
                        </div>

                        <div className="my-3">
                        
                            <Label for="content" >Post Content</Label>
                            {/* {<Input
                                type="textarea"
                                id="postContent"
                                placeholder="Enter here"
                                className="rounded-0"  
                                 name="postContent"
                                 value={content}
                                 
                                
                                
                            /> } */}
                            <JoditEditor
                                ref={editor}
                                value={content}
                                onChange={(a) => onContentChanged(a)}
                                
                            />
                     
                       
                        </div>


                        {/* <div className="my-3">
                        <Label for="content" >Post Content</Label>

                            <JoditEditor
                                ref={editor}
                                value={content}
                                onChange={onContentChanged}
                            />
                            <h1>{content}</h1>
                        </div> */}

                        <Container className="text-center">
                            <Button type="submit" className="rounded-0" color="primary" onClick={onSavePostClicked}
                    disabled={!canSave}>Create Post</Button>
                            <Button onClick={resetAll} className="rounded-0 ms-2" color="danger">Reset Content</Button>
                        </Container>


                    </Form>


                </CardBody>

            </Card>




        </div>
        </Base>
        </section>
    )
}
export default AddPostForm