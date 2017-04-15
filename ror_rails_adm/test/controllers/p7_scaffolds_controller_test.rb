require 'test_helper'

class P7ScaffoldsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @p7_scaffold = p7_scaffolds(:one)
  end

  test "should get index" do
    get p7_scaffolds_url
    assert_response :success
  end

  test "should get new" do
    get new_p7_scaffold_url
    assert_response :success
  end

  test "should create p7_scaffold" do
    assert_difference('P7Scaffold.count') do
      post p7_scaffolds_url, params: { p7_scaffold: { birthday: @p7_scaffold.birthday, email: @p7_scaffold.email, name: @p7_scaffold.name } }
    end

    assert_redirected_to p7_scaffold_url(P7Scaffold.last)
  end

  test "should show p7_scaffold" do
    get p7_scaffold_url(@p7_scaffold)
    assert_response :success
  end

  test "should get edit" do
    get edit_p7_scaffold_url(@p7_scaffold)
    assert_response :success
  end

  test "should update p7_scaffold" do
    patch p7_scaffold_url(@p7_scaffold), params: { p7_scaffold: { birthday: @p7_scaffold.birthday, email: @p7_scaffold.email, name: @p7_scaffold.name } }
    assert_redirected_to p7_scaffold_url(@p7_scaffold)
  end

  test "should destroy p7_scaffold" do
    assert_difference('P7Scaffold.count', -1) do
      delete p7_scaffold_url(@p7_scaffold)
    end

    assert_redirected_to p7_scaffolds_url
  end
end
