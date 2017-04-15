require 'test_helper'

class P9OutControllerTest < ActionDispatch::IntegrationTest
  test "should get index" do
    get p9_out_index_url
    assert_response :success
  end

end
