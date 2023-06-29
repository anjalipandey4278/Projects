import Base from "../Base";
import { Container, Row, Col } from "reactstrap";
import PostsList from "./PostsList";
const Home = () => {
  return (

    <Base>
    <Container className="mt-3">
      <Row>
        
        <Col md={10}>
         <PostsList/>
        </Col>
      </Row>
    </Container>
  </Base>
      )}
 


export default Home;