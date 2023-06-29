import TimeAgo from "./TimeAgo";
import ReactionButtons from "./ReactionButtons";
import { Link } from 'react-router-dom';
import { deletePost } from "./postsSlice";
import { useDispatch, useSelector } from 'react-redux';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { useNavigate } from 'react-router-dom'

 
const PostsExcerpt = ({ post }) => {
    const dispatch = useDispatch()
    const navigate = useNavigate()
    
    
    return (
        <div id='cen'>
        <Card className="text-center">
          
          <Card.Body>
    
            <Card.Title>{post.title}</Card.Title>
            <div id='like'>
           <ReactionButtons post={post} />
            </div>
            <Card.Text>
            {post.body.substring(0, 100)}
            </Card.Text>
            <Button variant="primary" id='pen'>
            <Link to={`post/${post.id}`}><i class="fa-solid fa-arrow-right"></i></Link></Button>
           
    
          </Card.Body>
          <Card.Footer className="text-muted"><TimeAgo timestamp={post.date} /></Card.Footer>
        </Card>
        </div>
    )
}
export default PostsExcerpt



